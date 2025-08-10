package com.adadev.tracker_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TextService {

    private final RestTemplate restTemplate;

    public TextService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sendText(String phone, String message) {
        String url = "https://textbelt.com/text";

        Map<String, String> request = Map.of(
            "phone", phone,
            "message", message,
            "key", "textbelt"
        );

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        return response.getBody();
    }
}
