package com.springboot.bookreviewsystem.project.dto;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.springboot.bookreviewsystem.project.entity.BookReview;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserAndReviewsDto {
	private String name;
	private List<BookReview> bookReviews;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BookReview> getBookReviews() {
		return bookReviews;
	}
	public void setBookReviews(List<BookReview> bookReviews) {
		this.bookReviews = bookReviews;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", bookReviews=" + bookReviews + "]";
	}

}
