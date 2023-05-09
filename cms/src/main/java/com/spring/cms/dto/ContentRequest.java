package com.spring.cms.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentRequest {

    @Size(max = 3, message = "criteria not met")
    private String title;

    private String body;
}
