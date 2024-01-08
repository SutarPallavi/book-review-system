package com.springboot.bookreviewsystem.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.springboot.bookreviewsystem.project.dto.UserAndReviewsDto;
import com.springboot.bookreviewsystem.project.entity.BookReview;
import com.springboot.bookreviewsystem.project.entity.UserAndReviews;
import com.springboot.bookreviewsystem.project.repo.UserAndReviewsRepositor;
import com.springboot.bookreviewsystem.project.utils.AppUtilts;

@Service
public class UserAndReviewsService {

	@Autowired
	private UserAndReviewsRepositor repositor;
	
	@Autowired
	MongoTemplate  mongoTemplate;
	
	public UserAndReviews addUserReview(UserAndReviewsDto userDto) {
		String name = userDto.getName();
		UserAndReviews user = repositor.findByName(name);
		if(user != null) {
			List<BookReview> bSList = userDto.getBookReviews();
			user.getBookReviews().addAll(bSList);
			updateUser(user);
			return user;
		} else 
			return repositor.save(AppUtilts.dtoToDocument(userDto));
	}
	
	public List<UserAndReviewsDto> getAllusers(){
		List<UserAndReviews> users = repositor.findAll();
		List<UserAndReviewsDto> userDtoList = new ArrayList<>();
		for(UserAndReviews user : users) {
			userDtoList.add(AppUtilts.documentToDto(user));
		}
		return userDtoList;
	}
	
	public UserAndReviews updateUser(UserAndReviews user) {
		Query query = new Query().addCriteria(Criteria.where("name").is(user.getName()));
		
		Update update = new Update().set("bookReviews", user.getBookReviews());
		
		return mongoTemplate.findAndModify(query, update, UserAndReviews.class);
	}
}
