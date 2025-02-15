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
  presentationMessage: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<{ English: string; French: string; Presentation: string }>('http://localhost:8080/api/welcome')
      .subscribe((data) => {
        this.englishMessage = data.English;
        this.frenchMessage = data.French;
        this.presentationMessage = data.Presentation;
      });
  }
}


