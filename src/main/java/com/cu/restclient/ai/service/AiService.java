package com.cu.restclient.ai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AiService {


    @Value("${openai.url}")
    private String openAiUrl;

    public RestClient client(String userApiKey) {
        return RestClient.builder()
                .baseUrl(openAiUrl)
                .requestInterceptor((request, body, execution) -> {
                    HttpHeaders headers = request.getHeaders();
                    headers.add("Authorization", userApiKey);
                    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    return execution.execute(request, body);
                })
                .build();
    }
}
