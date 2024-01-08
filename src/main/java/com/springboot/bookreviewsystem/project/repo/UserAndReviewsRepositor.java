package com.springboot.bookreviewsystem.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bookreviewsystem.project.entity.UserAndReviews;

@Repository
public interface UserAndReviewsRepositor extends MongoRepository<UserAndReviews, String> {

	UserAndReviews findByName(String name);
}
