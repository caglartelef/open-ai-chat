package com.caglartelef.openaichat.response;

import com.caglartelef.openaichat.feign.common.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    private String id;
    private Long created;
    private Message message;
}
