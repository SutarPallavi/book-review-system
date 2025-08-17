package com.springboot.bookreviewsystem.project.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "CustomerMails")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerMail {

    @Id
    private String id;
    
    @Field("name")
    private String name;
    
    @Field("email")
    private String email;
    
    @Field("subject")
    private String subject;
    
    @Field("message")
    private String message;
    
    @Field("submittedAt")
    private LocalDateTime submittedAt;
    
    @Field("status")
    private String status; // "new", "read", "replied"
}
