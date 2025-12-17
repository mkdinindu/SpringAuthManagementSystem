package com.practice.usermanagement.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    private String id;


    private String email;


    private String password;


    private String role = "ROLE_USER";



}
