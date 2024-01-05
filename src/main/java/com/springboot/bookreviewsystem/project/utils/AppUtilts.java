package com.springboot.bookreviewsystem.project.utils;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.springboot.bookreviewsystem.project.dto.BookDto;
import com.springboot.bookreviewsystem.project.dto.UserDto;
import com.springboot.bookreviewsystem.project.entity.Book;
import com.springboot.bookreviewsystem.project.entity.User;

public class AppUtilts {

	public static Book dtoToDocument(BookDto bookDto) {
		Book book = new Book();
		BeanUtils.copyProperties(bookDto, book);
		return book;
	}
	
	public static BookDto documentToDto(Book book) {
		BookDto bookDto = new BookDto();
		BeanUtils.copyProperties(book, bookDto);
		return bookDto;
	}
	
	
	public static User dtoToDocument(UserDto userDto) {		
		User user = User.builder().name(userDto.getName()).bookReviews(userDto.getBookReviews().stream().collect(Collectors.toList())).build();
		//BeanUtils.copyProperties(userDto, user);
		return user;
	}
	
	public static UserDto documentToDto(User user) {
		UserDto userDto = UserDto.builder().name(user.getName()).bookReviews(user.getBookReviews()).build();		
		//BeanUtils.copyProperties(user, userDto);
		return userDto;
	}
}
