package edu.wgu.d387_sample_code;


import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeMessage {
    public static void main(String[] args) {
        Thread englishThread = new Thread(() -> displayMessage("en"));
        Thread frenchThread = new Thread(() -> displayMessage("fr"));

        englishThread.start();
        frenchThread.start();
    }

    private static void displayMessage(String language) {
        Locale locale = new Locale(language);
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        System.out.println(bundle.getString("welcome.message"));
    }
}

