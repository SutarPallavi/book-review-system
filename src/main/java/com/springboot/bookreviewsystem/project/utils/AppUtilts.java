package com.springboot.bookreviewsystem.project.utils;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springboot.bookreviewsystem.project.dto.BookDto;
import com.springboot.bookreviewsystem.project.dto.UserAndReviewsDto;
import com.springboot.bookreviewsystem.project.dto.UserDto;
import com.springboot.bookreviewsystem.project.dto.UserProfileDto;
import com.springboot.bookreviewsystem.project.entity.Book;
import com.springboot.bookreviewsystem.project.entity.SequenceGenerator;
import com.springboot.bookreviewsystem.project.entity.User;
import com.springboot.bookreviewsystem.project.entity.UserAndReviews;
import com.springboot.bookreviewsystem.project.entity.UserProfile;

@Component
public class AppUtilts {

	@Autowired
	private SequenceGenerator sequenseGenerator;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	
	
	public static UserAndReviews dtoToDocument(UserAndReviewsDto userDto) {		
		UserAndReviews user = UserAndReviews.builder().name(userDto.getName()).bookReviews(userDto.getBookReviews().stream().collect(Collectors.toList())).build();
		//BeanUtils.copyProperties(userDto, user);
		return user;
	}
	
	public static UserAndReviewsDto documentToDto(UserAndReviews user) {
		UserAndReviewsDto userDto = UserAndReviewsDto.builder()
				.name(user.getName())
				.bookReviews(user.getBookReviews())
				.build();
		return userDto;
	}
	
	public UserProfile dtoToDocument(UserProfileDto userProfileDto) {
		UserProfile userProfile = UserProfile.builder()
				.userName(userProfileDto.getUserName())
				.firstName(userProfileDto.getFirstName())
				.lastName(userProfileDto.getLastName())
				.emailId(userProfileDto.getEmailId())
				.favoriteBookGeners(userProfileDto.getFavoriteBookGeners())
				.favoriteBookNames(userProfileDto.getFavoriteBookNames())
				.build();
		userProfile.setUserID(sequenseGenerator.getNextSequenceId(UserProfile.SEQUENCE_NAME));
		return userProfile;
	}
	
	public static UserProfileDto documentToDto(UserProfile userProfile) {
		UserProfileDto userProfileDto = UserProfileDto.builder()
				.firstName(userProfile.getFirstName())
				.lastName(userProfile.getLastName())
				.emailId(userProfile.getEmailId())
				.favoriteBookGeners(userProfile.getFavoriteBookGeners())
				.favoriteBookNames(userProfile.getFavoriteBookNames())
				.build();
		return userProfileDto;
	}
	
	public User dtoToDocument(UserDto userDto) {
		User user = User.builder()
				.name(userDto.getFirstName() + " "+ userDto.getLastName())
				.email(userDto.getEmail())
				.password(passwordEncoder.encode(userDto.getPassword()))
				.build();
		user.setId(sequenseGenerator.getNextSequenceId(User.SEQUENCE_NAME));
		return user;
	}
	
	public static UserDto documentToDto(User user) {
		String[] name = user.getName().split(" ");
		
		UserDto userDto = UserDto.builder()
				.firstName(name[0])
				.lastName(name[1])
				.email(user.getEmail())
				.password(user.getPassword())
				.build();
		return userDto;
	}
}
