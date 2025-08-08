package com.adadev.tracker_backend.controller;

import com.adadev.tracker_backend.service.TextService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/texts")
public class TextController {

    private final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendText(@RequestBody Map<String, String> payload) {
        String phone = payload.get("phone");
        String message = payload.getOrDefault("message", "Don't forget to log!");

        if (phone == null || phone.isEmpty()) {
            return ResponseEntity.badRequest().body("Phone number is required");
        }

        try {
            String result = textService.sendText(phone, message);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error sending text: " + e.getMessage());
        }
    }
}
