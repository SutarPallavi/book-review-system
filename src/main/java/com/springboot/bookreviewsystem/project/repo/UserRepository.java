package com.springboot.bookreviewsystem.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.bookreviewsystem.project.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	User findByEmail(String email);

}
