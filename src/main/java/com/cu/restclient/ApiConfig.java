package com.cu.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ApiConfig {
    @Value("${dummyapi}")
    private String dummyApi;

    @Bean
    public RestClient dummyRestClient() {
        return RestClient
                .builder()
                .baseUrl(dummyApi)
                .build();
    }
}
