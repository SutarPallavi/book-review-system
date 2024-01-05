package com.springboot.bookreviewsystem.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bookreviewsystem.project.entity.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {

}
