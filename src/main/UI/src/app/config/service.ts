import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

export interface Config {
  id: string;
  roomNumber: string;
  price: string;
  links: string;
}

@Injectable({
  providedIn: 'root',
})
export class ConfigService {
  private configUrl = 'assets/config.json';
  private welcomeUrl = 'http://localhost:8080/api/welcome'; // Back-end API URL

  constructor(private http: HttpClient) {}

  // Fetch welcome messages from the back end
  getWelcomeMessages(): Observable<{ English: string; French: string; Presentation: string }> {
    return this.http.get<{ English: string; French: string; Presentation: string }>(this.welcomeUrl).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }

  // Fetch configuration data
  getConfig(): Observable<Config> {
    return this.http.get<Config>(this.configUrl).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.status === 0) {
      console.error('An error occurred:', error.error);
    } else {
      console.error(`Backend returned code ${error.status}, body was:`, error.error);
    }
    return throwError(() => new Error('Something went wrong; please try again later.'));
  }
}
