package com.springboot.bookreviewsystem.project.dto;

import java.util.List;

import com.springboot.bookreviewsystem.project.entity.Book;
import com.springboot.bookreviewsystem.project.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooksAndReviewsDto {

	private Book  book;
	private List<UserAndReviewDto> userAndReviewDtos;
}
