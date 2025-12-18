package com.practice.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class LoginResponse {  //this dto returns the jwt token.
    private String token;
}
