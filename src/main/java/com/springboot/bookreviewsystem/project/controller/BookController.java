package com.springboot.bookreviewsystem.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookreviewsystem.project.dto.BookDto;
import com.springboot.bookreviewsystem.project.dto.BooksAndReviewsDto;
import com.springboot.bookreviewsystem.project.entity.Book;
import com.springboot.bookreviewsystem.project.response.BookResponse;
import com.springboot.bookreviewsystem.project.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/books/savebook")
	public ResponseEntity<BookResponse> saveBook(@RequestBody BookDto bookDto){
		Book book = bookService.saveBook(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new BookResponse(book.getName(), LocalDateTime.now()));
	}
	
	@GetMapping("/books/getAllBooks")
	public ResponseEntity<List<BookDto>> getAllBooks(){
		List<BookDto> booksList = bookService.getAllBooks();
		return ResponseEntity.ok().body(booksList);
	}
	
	@GetMapping("/books/getBooksAndReviews")
	public ResponseEntity<List<BooksAndReviewsDto>> getAll(){
		List<BooksAndReviewsDto> booksAndReviewsDtosList = bookService.getAllBooksAndReviews();
		return ResponseEntity.ok().body(booksAndReviewsDtosList);
	}
}
