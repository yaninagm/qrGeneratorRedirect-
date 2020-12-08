package com.front.qrGeneratorRedirect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public WebClient localApiClient() {
        return WebClient.create("https://real-customer.herokuapp.com");
    }

}
