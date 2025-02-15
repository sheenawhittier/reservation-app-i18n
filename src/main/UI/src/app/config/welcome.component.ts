import { Component, OnInit } from '@angular/core';
import { ConfigService } from './service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css'],
})
export class WelcomeComponent implements OnInit {
  englishMessage: string = '';
  frenchMessage: string = '';
  presentationMessage: string = '';

  constructor(private configService: ConfigService) {}

  ngOnInit(): void {
    this.configService.getWelcomeMessages().subscribe({
      next: (data) => {
        this.englishMessage = data.English;
        this.frenchMessage = data.French;
        this.presentationMessage = data.Presentation;
      },
      error: (error) => {
        console.error('Error fetching welcome messages:', error);
      },
    });
  }
}


