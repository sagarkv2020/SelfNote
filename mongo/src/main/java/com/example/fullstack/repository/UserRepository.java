package com.example.fullstack.repository;

import com.example.fullstack.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

