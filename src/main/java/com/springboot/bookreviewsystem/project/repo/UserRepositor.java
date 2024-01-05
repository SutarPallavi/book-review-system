package com.springboot.bookreviewsystem.project.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bookreviewsystem.project.entity.BookReview;
import com.springboot.bookreviewsystem.project.entity.User;

@Repository
public interface UserRepositor extends MongoRepository<User, String> {

	User findByName(String name);
}
