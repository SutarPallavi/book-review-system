package com.springboot.bookreviewsystem.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookDto {

	private String name;
	private String authore;
	private String genre;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthore() {
		return authore;
	}
	public void setAuthore(String authore) {
		this.authore = authore;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", genre=" + genre + ", authore=" + authore + "]";
	}
}
