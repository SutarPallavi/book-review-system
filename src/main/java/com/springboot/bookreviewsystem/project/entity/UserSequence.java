package com.springboot.bookreviewsystem.project.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "user_seq")
@AllArgsConstructor
@NoArgsConstructor
public class UserSequence {

	@Id
	private String id;
	@Field("sequence_number")
	private long sequence;
}
