package com.spring.cms.global;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageResponse {

    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }
}
