package edu.wgu.d387_sample_code.service;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class WelcomeMessageService {

        public String displayMessage(String language) {
            Locale locale = new Locale(language);
            ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
            return bundle.getString("welcome.message");
        }
    }




