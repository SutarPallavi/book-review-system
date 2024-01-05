package com.springboot.bookreviewsystem.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookReview {
	
	private String name;
	private String review;
	private double raiting;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public double getRaiting() {
		return raiting;
	}
	public void setRaiting(double raiting) {
		this.raiting = raiting;
	}
	@Override
	public String toString() {
		return "BookReview [name=" + name + ", review=" + review + ", raiting=" + raiting + "]";
	}
}
