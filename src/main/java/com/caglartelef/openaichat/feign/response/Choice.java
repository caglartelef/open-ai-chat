package com.caglartelef.openaichat.feign.response;

import com.caglartelef.openaichat.feign.common.Message;
import lombok.Data;

@Data
public class Choice {
    private Message message;
    private String finish_reason;
    private int index;
}
