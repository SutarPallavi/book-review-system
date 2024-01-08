package com.springboot.bookreviewsystem.project.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

	public static final String SEQUENCE_NAME = "users";
	@Id()
	@Field("_id")
	private long id;
	private String name;
	private String email;
	private String password;
	private List<Role> roles;
}
