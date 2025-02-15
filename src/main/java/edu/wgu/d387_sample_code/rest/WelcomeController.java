package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.service.TimeZoneService;
import edu.wgu.d387_sample_code.service.WelcomeMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @Autowired
    private TimeZoneService timeZoneService;

    @GetMapping("/welcome")
    public Map<String, String> getWelcomeMessage() {
        Map<String, String> messages = new HashMap<>();
        messages.put("English", "Welcome to Landon Hotel!");
        messages.put("French", "Bienvenue à l'hôtel Landon!");

        // Add time zone information to the presentation message
        String presentationMessage = timeZoneService.getPresentationTimes();
        messages.put("Presentation", presentationMessage);

        return messages;
    }
}
