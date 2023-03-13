package com.caglartelef.openaichat.feign.request;

import com.caglartelef.openaichat.feign.common.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatCompletionRequest {
    private String model;
    private String user;
    private List<Message> messages;


}
