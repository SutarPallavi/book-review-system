package com.springboot.bookreviewsystem.project.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "role_seq")
@AllArgsConstructor
@NoArgsConstructor
public class RoleSequence {
	
	@Id
	private String id;
	@Field("SEQUENCE_ROLE_NAME")
	private long sequence;
}
