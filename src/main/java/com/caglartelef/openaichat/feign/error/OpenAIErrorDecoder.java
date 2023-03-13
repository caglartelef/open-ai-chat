package com.caglartelef.openaichat.feign.error;

import com.caglartelef.openaichat.exception.exceptions.OpenAIServerException;
import com.caglartelef.openaichat.feign.exception.ExceptionMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class OpenAIErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    private final ObjectMapper objectMapper;

    /*
CODE
401 - Invalid Authentication
    Cause: Invalid Authentication
    Solution: Ensure the correct API key and requesting organization are being used.

401 - Incorrect API key provided
    Cause: The requesting API key is not correct.
    Solution: Ensure the API key used is correct, clear your browser cache, or generate a new one.

401 - You must be a member of an organization to use the API
    Cause: Your account is not part of an organization.
    Solution: Contact us to get added to a new organization or ask your organization manager to invite you to an organization.

429 - Rate limit reached for requests
    Cause: You are sending requests too quickly.
    Solution: Pace your requests. Read the Rate limit guide.

429 - You exceeded your current quota, please check your plan and billing details
    Cause: You have hit your maximum monthly spend (hard limit) which you can view in the account billing section.
    Solution: Apply for a quota increase.

429 - The engine is currently overloaded, please try again later
    Cause: Our servers are experiencing high traffic.
    Solution: Please retry your requests after a brief wait.

500 - The server had an error while processing your request
    Cause: Issue on our servers.
    Solution: Retry your request after a brief wait and contact us if the issue persists. Check the status page.
    * */

    @Override
    public Exception decode(String methodKey, Response response) {
        log.error("[decode] -> raw response: {}", response);
        if (Objects.nonNull(response.body())) {
            ExceptionMessage message;
            try (InputStream bodyIs = response.body().asInputStream()) {
                message = objectMapper.readValue(bodyIs, ExceptionMessage.class);
                log.error("[decode] -> deserialized response: {}", message);
            } catch (IOException e) {
                log.error("[decode] -> response message can not deserialize! response: {}", response);
            }
        }

        switch (response.status()) {
            case 401:
                // You can get different action
                return new OpenAIServerException(response.reason());
            case 429:
                // You can get different action
                return new OpenAIServerException(response.reason());
            case 500:
                // You can get different action
                return new OpenAIServerException(response.reason());
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}
