package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.service.WelcomeMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @Autowired
    private WelcomeMessageService welcomeMessageService;

    @GetMapping("/welcome")
    public Map<String, String> getWelcomeMessages() {
        Map<String, String> messages = new HashMap<>();
        messages.put("English", welcomeMessageService.displayMessage("en"));
        messages.put("French", welcomeMessageService.displayMessage("fr"));
        return messages;
    }
}
