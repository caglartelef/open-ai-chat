package com.caglartelef.openaichat.exception.handler;

import com.caglartelef.openaichat.exception.exceptions.OpenAIServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(OpenAIServerException.class)
    public ResponseEntity handleVerificationCodeCanNotVerifyException(OpenAIServerException exception) {
        return ResponseEntity.badRequest().body(exception.getReason());
    }

}
