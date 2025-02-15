package edu.wgu.d387_sample_code.rest;

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

    @GetMapping("/welcome")
    public ResponseEntity<Map<String, String>> getWelcomeMessages() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<String> fetchEnglishMessage = () -> "Welcome to Landon Hotel!";
        Callable<String> fetchFrenchMessage = () -> "Bienvenue à l'hôtel Landon!";

        Future<String> englishFuture = executor.submit(fetchEnglishMessage);
        Future<String> frenchFuture = executor.submit(fetchFrenchMessage);

        Map<String, String> messages = new HashMap<>();
        messages.put("English", englishFuture.get());
        messages.put("French", frenchFuture.get());
        messages.put("Presentation", "Landon Hotel is committed to providing the best experience!");

        executor.shutdown();
        return ResponseEntity.ok(messages);
    }
}

