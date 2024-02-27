package com.cu.restclient.ai.controller;

import com.cu.restclient.ai.dto.ChatGptRequest;
import com.cu.restclient.ai.dto.ChatGptResponse;
import com.cu.restclient.ai.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AiController {
    @Autowired
    private AiService aiService;

    @PostMapping("/chat")
    public ResponseEntity<?> chat(@RequestBody ChatGptRequest gptRequest, @RequestHeader("Authorization") String userApiKey) {
        try {
            RestClient client = aiService.client(userApiKey);
            ChatGptResponse response = client.post().body(gptRequest).retrieve().body(ChatGptResponse.class);
            String content = response.getChoices().get(0).getMessage().getContent();
            return new ResponseEntity<>(content, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error during chat API call", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
