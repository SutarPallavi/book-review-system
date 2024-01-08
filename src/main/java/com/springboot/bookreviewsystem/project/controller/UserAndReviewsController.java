package com.springboot.bookreviewsystem.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookreviewsystem.project.dto.UserAndReviewsDto;
import com.springboot.bookreviewsystem.project.entity.UserAndReviews;
import com.springboot.bookreviewsystem.project.response.UserResponse;
import com.springboot.bookreviewsystem.project.service.UserAndReviewsService;

@RestController
@RequestMapping("/book-review-system")
public class UserAndReviewsController {

	@Autowired
	private UserAndReviewsService service;
	
	@PostMapping("/users/userreviews")
	public ResponseEntity<UserResponse> addUserReview(@RequestBody UserAndReviewsDto dto){
		UserAndReviews user = service.addUserReview(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(user.getName(), LocalDateTime.now()));
	}
	
	@GetMapping("/users/getuserlist")
	public List<UserAndReviewsDto> getAllusers(){
		return service.getAllusers();
	}
}
