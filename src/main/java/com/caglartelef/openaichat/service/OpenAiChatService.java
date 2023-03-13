package com.caglartelef.openaichat.service;

import com.caglartelef.openaichat.feign.response.ChatCompletionResponse;
import com.caglartelef.openaichat.request.MessageRequest;

public interface OpenAiChatService {

    ChatCompletionResponse message(final MessageRequest messageRequest);
}
