package com.springboot.bookreviewsystem.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bookreviewsystem.project.entity.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String>{

}
