package com.springboot.bookreviewsystem.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactFormDto {
    private String name;
    private String email;
    private String subject;
    private String message;
}
