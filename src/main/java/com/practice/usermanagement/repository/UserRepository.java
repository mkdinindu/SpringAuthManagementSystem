package com.practice.usermanagement.repository;

import com.practice.usermanagement.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {   // just changed the jpa repository to mongo one. i love springboot

    Optional<User> findByEmail(String email);



    boolean existsByEmail(String email);                   //not used....just checks if the user is there.
}
