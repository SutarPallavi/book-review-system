package com.springboot.bookreviewsystem.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.bookreviewsystem.project.entity.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, Long>{

    UserProfile findByEmailId(String emailId);

    UserProfile findByUserName(String userName);

    @Query(value = "{ 'emailId': { $regex: ?0, $options: 'i' } }")
    UserProfile findByEmailIdRegex(String emailIdPattern);

    @Query(value = "{ 'userName': { $regex: ?0, $options: 'i' } }")
    UserProfile findByUserNameRegex(String userNamePattern);
}
