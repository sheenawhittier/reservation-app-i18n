# Stage 1: Angular Build
FROM node:18.19-alpine AS angular-build

# Set the working directory for the Angular project
WORKDIR /app

# Copy package.json and package-lock.json to install dependencies
COPY src/main/UI/package*.json ./

# Install Angular CLI and dependencies
RUN npm install -g @angular/cli && npm install

# Verify Node.js, npm, and Angular CLI versions
RUN node -v && npm -v && ng version

# Copy the rest of the Angular source code into the container
COPY src/main/UI/ ./

# Build the Angular app in production mode
RUN ng build --configuration production

# Stage 2: Spring Boot Build
FROM openjdk:17-jdk-slim AS spring-boot-build

# Set the working directory for the Spring Boot project
WORKDIR /app

# Copy the Spring Boot JAR file
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar

# Stage 3: Final Combined Image
FROM openjdk:17-jdk-slim

# Set the working directory for the runtime container
WORKDIR /app

# Copy the Spring Boot JAR file from the spring-boot-build stage
COPY --from=spring-boot-build /app/app.jar ./app.jar

# Copy the Angular build output from the angular-build stage
COPY --from=angular-build /app/dist/ /app/dist/

# Expose the port for the application
EXPOSE 8080

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]
