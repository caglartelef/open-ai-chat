package com.caglartelef.openaichat.feign.response;

import lombok.Data;

import java.util.List;

@Data
public class ChatCompletionResponse {
    private String id;
    private String object;
    private Long created;
    private String model;
    private Usage usage;
    private List<Choice> choices;
}
