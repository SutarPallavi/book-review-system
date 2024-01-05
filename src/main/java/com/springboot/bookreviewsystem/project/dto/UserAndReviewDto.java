package com.springboot.bookreviewsystem.project.dto;

import java.util.Optional;

import com.springboot.bookreviewsystem.project.entity.BookReview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAndReviewDto {

	private String userName;
	private Optional<BookReview> bookReviews;
}
