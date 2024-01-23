package com.springboot.bookreviewsystem.project.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "books")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Book {

	private String name;
	private String author;
	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthore() {
		return author;
	}
	public void setAuthore(String authore) {
		this.author = authore;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [ name=" + name + ", authore=" + author + ", price=" + price + "]";
	}
}
