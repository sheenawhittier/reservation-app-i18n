![Java CI](https://github.com/sheenawhittier/reservation-app-i18n/actions/workflows/build.yml/badge.svg)

# Reservation App (i18n + Docker)

Spring Boot reservation service with **internationalization** and a **containerized** runtime.

![Java CI](https://github.com/sheenawhittier/reservation-app-i18n/actions/workflows/build.yml/badge.svg)

## 🚀 Tech Stack
- **Backend:** Java 17, Spring Boot, Spring MVC
- **i18n:** message bundles (e.g., `messages_en.properties`, `messages_es.properties`)
- **Build/Run:** Maven, Docker
- **CI:** GitHub Actions

## ✨ Features
- Create / view / update reservations
- Locale-aware UI/messages (`en`, `es`, `fr`, …)
- Dockerized image for easy deployment

## 🔧 Run locally
```bash
mvn clean spring-boot:run
