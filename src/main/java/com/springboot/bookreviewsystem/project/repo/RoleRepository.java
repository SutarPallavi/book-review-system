package com.springboot.bookreviewsystem.project.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.bookreviewsystem.project.entity.Role;

public interface RoleRepository extends MongoRepository<Role, Long>{

	Role findByName(String string);

}
