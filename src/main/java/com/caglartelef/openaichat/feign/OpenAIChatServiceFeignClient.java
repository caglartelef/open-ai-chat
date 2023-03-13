package com.caglartelef.openaichat.feign;

import com.caglartelef.openaichat.feign.request.ChatCompletionRequest;
import com.caglartelef.openaichat.feign.response.ChatCompletionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${feign.open-ai-chat-service.name}", url = "${feign.open-ai-chat-service.base-url}")
public interface OpenAIChatServiceFeignClient {
    @PostMapping(value = "/v1/chat/completions")
    ChatCompletionResponse chatCompletions(@RequestHeader("Authorization") String token,
                                           @RequestBody ChatCompletionRequest chatCompletionRequest);
}
