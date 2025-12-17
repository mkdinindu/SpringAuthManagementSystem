package com.practice.usermanagement.repository;

import com.practice.usermanagement.entity.Role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {   //Not used class.

    Optional<Role> findByName(String name);

}
