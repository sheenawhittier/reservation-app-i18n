import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  englishMessage: string = '';
  frenchMessage: string = '';

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.http.get<{ English: string; French: string }>('http://localhost:8080/api/welcome')
      .subscribe(
        (data) => {
          this.englishMessage = data.English;
          this.frenchMessage = data.French;
        },
        (error) => {
          console.error('Error fetching welcome messages:', error);
        }
      );
  }
}

