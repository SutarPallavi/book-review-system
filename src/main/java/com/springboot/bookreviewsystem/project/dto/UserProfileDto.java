package com.springboot.bookreviewsystem.project.dto;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;

import com.springboot.bookreviewsystem.project.entity.Book;
import com.springboot.bookreviewsystem.project.enums.BookGeners;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDto {
	private String userName;
	private String firstName;
	private String lastName;
	private String emailId;
	private List<BookGeners> favoriteBookGeners;
	private List<String> favoriteBookNames;
}
