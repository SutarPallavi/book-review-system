package com.springboot.bookreviewsystem.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bookreviewsystem.project.entity.CustomerMail;

@Repository
public interface CustomerMailRepository extends MongoRepository<CustomerMail, String> {
    
}
