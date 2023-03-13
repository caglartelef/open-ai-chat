package com.caglartelef.openaichat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenAiChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenAiChatApplication.class, args);
    }

}
