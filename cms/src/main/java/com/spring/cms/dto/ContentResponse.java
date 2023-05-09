package com.spring.cms.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContentResponse {

    private Long id;

    private String title;

    private String body;
}
