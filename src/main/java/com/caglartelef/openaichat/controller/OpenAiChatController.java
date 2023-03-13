package com.caglartelef.openaichat.controller;

import com.caglartelef.openaichat.feign.response.ChatCompletionResponse;
import com.caglartelef.openaichat.request.MessageRequest;
import com.caglartelef.openaichat.response.MessageResponse;
import com.caglartelef.openaichat.service.OpenAiChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/1.0/open-ai-chat")
public class OpenAiChatController {
    private final OpenAiChatService chatService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/message")
    public ResponseEntity<MessageResponse> chat(@RequestBody MessageRequest messageRequest) {
        log.debug("[chat] -> request: {}", messageRequest);
        ChatCompletionResponse chatCompletionResponse = chatService.message(messageRequest);
        MessageResponse messageResponse = buildMessageResponse(chatCompletionResponse);
        log.debug("[chat] -> response: {}", messageResponse);
        return ResponseEntity.ok(messageResponse);
    }

    private MessageResponse buildMessageResponse(final ChatCompletionResponse chatCompletionResponse) {
        return MessageResponse.builder()
                              .id(chatCompletionResponse.getId())
                              .created(chatCompletionResponse.getCreated())
                              .message(chatCompletionResponse.getChoices().get(0).getMessage())
                              .build();
    }

}
