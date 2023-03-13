package com.caglartelef.openaichat.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "open-ai")
public class OpenAIProperties {
    private String model;
    private String apiKey;
}
