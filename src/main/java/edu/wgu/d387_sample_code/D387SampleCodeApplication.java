package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.service.WelcomeMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		WelcomeMessageService messageService = new WelcomeMessageService();

		Thread englishThread = new Thread(() -> messageService.displayMessage("en"));
		Thread frenchThread = new Thread(() -> messageService.displayMessage("fr"));

		englishThread.start();
		frenchThread.start();
	}
}


