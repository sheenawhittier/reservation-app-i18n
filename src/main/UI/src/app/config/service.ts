import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
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
  configUrl = 'assets/config.json';
  welcomeUrl = 'http://localhost:8080/api/welcome'; // Back-end API URL

  constructor(private http: HttpClient) {}

  // Fetch welcome messages from the back end
  getWelcomeMessages(): Observable<any> {
    return this.http.get<any>(this.welcomeUrl).pipe(
      retry(3), // Retry the request up to 3 times
      catchError(this.handleError) // Handle errors
    );
  }

  // Existing configuration fetching methods
  getConfig() {
    return this.http.get<Config>(this.configUrl).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('An error occurred:', error.error);
    } else {
      console.error(`Backend returned code ${error.status}, body was: `, error.error);
    }
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}



