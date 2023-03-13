package com.caglartelef.openaichat.request;

import lombok.Data;

@Data
public class MessageRequest {
    // You can identify the user with is property
    private String userId;
    private String content;
    private String role;
}
