package com.practice.usermanagement.repository;

import com.practice.usermanagement.entity.Role;
import com.practice.usermanagement.entity.User;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);



    boolean existsByEmail(String email);
}
