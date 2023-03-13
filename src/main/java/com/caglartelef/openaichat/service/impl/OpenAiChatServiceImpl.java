package com.caglartelef.openaichat.service.impl;

import com.caglartelef.openaichat.feign.OpenAIChatServiceFeignClient;
import com.caglartelef.openaichat.feign.common.Message;
import com.caglartelef.openaichat.feign.request.ChatCompletionRequest;
import com.caglartelef.openaichat.feign.response.ChatCompletionResponse;
import com.caglartelef.openaichat.properties.OpenAIProperties;
import com.caglartelef.openaichat.request.MessageRequest;
import com.caglartelef.openaichat.service.OpenAiChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenAiChatServiceImpl implements OpenAiChatService {
    private final OpenAIChatServiceFeignClient openAIChatServiceFeignClient;
    private final OpenAIProperties properties;

    @Override
    public ChatCompletionResponse message(final MessageRequest messageRequest) {
        log.debug("[message] -> request: {}", messageRequest);
        final ChatCompletionRequest chatCompletionRequest = buildChatCompletionRequest(messageRequest);
        ChatCompletionResponse chatCompletionResponse;
        chatCompletionResponse = openAIChatServiceFeignClient.chatCompletions(properties.getApiKey(), chatCompletionRequest);
        log.debug("[message] -> response: {}", chatCompletionResponse);
        return chatCompletionResponse;
    }

    private ChatCompletionRequest buildChatCompletionRequest(final MessageRequest messageRequest) {
        return ChatCompletionRequest.builder()
                                    .model(properties.getModel())
                                    .user(messageRequest.getUserId())
                                    .messages(List.of(Message.builder()
                                                             .role(messageRequest.getRole())
                                                             .content(messageRequest.getContent())
                                                             .build()))
                                    .build();
    }

}
