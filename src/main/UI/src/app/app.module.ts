import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './config/welcome.component';
import { ConfigService } from './config/service';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent, // Register WelcomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, // Import HttpClientModule
    ReactiveFormsModule,
  ],
  providers: [ConfigService], // Provide ConfigService
  bootstrap: [AppComponent],
})
export class AppModule {}

