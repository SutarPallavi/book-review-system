package com.springboot.bookreviewsystem.project.dto;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;

import com.springboot.bookreviewsystem.project.entity.Book;
import com.springboot.bookreviewsystem.project.enums.BookGenres;

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
	private String password; // plain on input; will be hashed before saving
	private List<BookGenres> favoriteBookGenres;
	private List<String> favoriteBookNames;
}
