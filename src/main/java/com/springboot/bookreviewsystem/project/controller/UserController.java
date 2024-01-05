package com.springboot.bookreviewsystem.project.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookreviewsystem.project.dto.UserDto;
import com.springboot.bookreviewsystem.project.entity.User;
import com.springboot.bookreviewsystem.project.response.UserResponse;
import com.springboot.bookreviewsystem.project.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/users/userreviews")
	public ResponseEntity<UserResponse> addUserReview(@RequestBody UserDto dto){
		User user = service.addUserReview(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(user.getName(), LocalDateTime.now()));
	}
	
	@GetMapping("/users")
	public List<UserDto> getAllusers(){
		return service.getAllusers();
	}
}
