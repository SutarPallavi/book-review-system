package com.springboot.bookreviewsystem.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bookreviewsystem.project.dto.BookDto;
import com.springboot.bookreviewsystem.project.dto.BooksAndReviewsDto;
import com.springboot.bookreviewsystem.project.dto.UserAndReviewDto;
import com.springboot.bookreviewsystem.project.entity.Book;
import com.springboot.bookreviewsystem.project.entity.User;
import com.springboot.bookreviewsystem.project.repo.BookRepository;
import com.springboot.bookreviewsystem.project.repo.UserRepositor;
import com.springboot.bookreviewsystem.project.utils.AppUtilts;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepositor userRepositor;
	
	public Book saveBook(BookDto bookDto) {
	
		return bookRepository.save(AppUtilts.dtoToDocument(bookDto));
	}
	
	public List<BookDto> getAllBooks(){
		List<Book> booksList =  bookRepository.findAll();
		List<BookDto> booksDtoList = new ArrayList<>();		
		for(Book book : booksList){
			booksDtoList.add(AppUtilts.documentToDto(book));
		}
		return booksDtoList;
	}
	
	public List<BooksAndReviewsDto> getAllBooksAndReviews (){
		List<Book> booksList = bookRepository.findAll();
		
		List<User> userList = userRepositor.findAll();
		
		List<BooksAndReviewsDto> booksAndReviewsList = new ArrayList<>();
		for(Book book : booksList) {
			List<User> usersBookReview = userList.stream()
					.filter(user -> 
					user.getBookReviews().stream().anyMatch( books -> books.getName().equals(book.getName()))).collect(Collectors.toList());
			List<UserAndReviewDto> userAndReviewDtos = new ArrayList<>();
			
			for(User user : usersBookReview) {
				userAndReviewDtos.add(UserAndReviewDto.builder()
						.userName(user.getName())
						.bookReviews(user.getBookReviews().stream().filter(b -> b.getName().equals(book.getName())).findFirst()).build());
			}
			booksAndReviewsList.add(BooksAndReviewsDto.builder().book(book).userAndReviewDtos(userAndReviewDtos).build());
		}
		
		return booksAndReviewsList;
	}
	
	public List<BookDto> getBooksByGenre(String genre){
		List<Book> booksList = bookRepository.findByGenre(genre);
		List<BookDto> booksDtoList = new ArrayList<>();		
		for(Book book : booksList){
			booksDtoList.add(AppUtilts.documentToDto(book));
		}
		return booksDtoList;
	}
}
