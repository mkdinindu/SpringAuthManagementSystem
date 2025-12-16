package com.practice.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterRequest {
    public String email;
    public  String password;
}
