package com.springboot.bookreviewsystem.project.utils;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.bookreviewsystem.project.dto.BookDto;
import com.springboot.bookreviewsystem.project.dto.UserDto;
import com.springboot.bookreviewsystem.project.dto.UserProfileDto;
import com.springboot.bookreviewsystem.project.entity.Book;
import com.springboot.bookreviewsystem.project.entity.SequenceGenerator;
import com.springboot.bookreviewsystem.project.entity.User;
import com.springboot.bookreviewsystem.project.entity.UserProfile;

@Component
public class AppUtilts {

	@Autowired
	private SequenceGenerator sequenseGenerator; 
	
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
		UserDto userDto = UserDto.builder()
				.name(user.getName())
				.bookReviews(user.getBookReviews())
				.build();
		return userDto;
	}
	
	public UserProfile dtoToDocument(UserProfileDto userProfileDto) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserProfile userProfile = UserProfile.builder()
				.userName(userProfileDto.getUserName())
				.firstName(userProfileDto.getFirstName())
				.lastName(userProfileDto.getLastName())
				.emailId(userProfileDto.getEmailId())
				.passwordHash(userProfileDto.getPassword() != null ? encoder.encode(userProfileDto.getPassword()) : null)
				.favoriteBookGenres(userProfileDto.getFavoriteBookGenres())
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
				.favoriteBookGenres(userProfile.getFavoriteBookGenres())
				.favoriteBookNames(userProfile.getFavoriteBookNames())
				.build();
		return userProfileDto;
	}
}
