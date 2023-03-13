package com.caglartelef.openaichat.exception.exceptions;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class OpenAIServerException extends RuntimeException {
    private final String reason;

    public OpenAIServerException(final String reason) {
        super();
        this.reason = reason;
        log.error("[OpenAIServerException] -> Open AI error reason: {}", reason);
    }
}
