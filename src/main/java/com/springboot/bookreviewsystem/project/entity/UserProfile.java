package com.springboot.bookreviewsystem.project.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.springboot.bookreviewsystem.project.enums.BookGeners;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "userprofiles")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

	public static final String SEQUENCE_NAME = "pallavi";
	@Id()
	@Field("_id")
	private long userID;
	@Indexed(unique = false)
	private String userName;
	private String firstName;
	private String lastName;
	private String emailId;
	private List<BookGeners> favoriteBookGeners;
	private List<String> favoriteBookNames;
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
}
