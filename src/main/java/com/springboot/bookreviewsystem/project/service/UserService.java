package com.springboot.bookreviewsystem.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.springboot.bookreviewsystem.project.dto.UserDto;
import com.springboot.bookreviewsystem.project.entity.BookReview;
import com.springboot.bookreviewsystem.project.entity.User;
import com.springboot.bookreviewsystem.project.repo.UserRepositor;
import com.springboot.bookreviewsystem.project.utils.AppUtilts;

@Service
public class UserService {

	@Autowired
	private UserRepositor repositor;
	
	@Autowired
	MongoTemplate  mongoTemplate;
	
	public User addUserReview(UserDto userDto) {
		String name = userDto.getName();
		User user = repositor.findByName(name);
		if(user != null) {
			List<BookReview> incomingReviews = userDto.getBookReviews();
			if (incomingReviews != null) {
				if (user.getBookReviews() == null) {
					user.setBookReviews(new ArrayList<>());
				}
				for (BookReview incoming : incomingReviews) {
					boolean updated = false;
					for (int i = 0; i < user.getBookReviews().size(); i++) {
						BookReview existing = user.getBookReviews().get(i);
						if (existing != null && existing.getName() != null && existing.getName().equals(incoming.getName())) {
							user.getBookReviews().set(i, incoming);
							updated = true;
							break;
						}
					}
					if (!updated) {
						user.getBookReviews().add(incoming);
					}
				}
			}
			updateUser(user);
			return user;
		} else 
			return repositor.save(AppUtilts.dtoToDocument(userDto));
	}
	
	public List<UserDto> getAllusers(){
		List<User> users = repositor.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		for(User user : users) {
			userDtoList.add(AppUtilts.documentToDto(user));
		}
		return userDtoList;
	}
	
	public User updateUser(User user) {
		Query query = new Query().addCriteria(Criteria.where("name").is(user.getName()));
		
		Update update = new Update().set("bookReviews", user.getBookReviews());
		
		return mongoTemplate.findAndModify(query, update, User.class);
	}
}
