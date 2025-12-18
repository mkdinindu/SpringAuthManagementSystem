package com.practice.usermanagement.service;

import com.practice.usermanagement.dto.LogInRequest;
import com.practice.usermanagement.dto.RegisterRequest;
import com.practice.usermanagement.entity.User;
import com.practice.usermanagement.repository.UserRepository;
import com.practice.usermanagement.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,

                       PasswordEncoder encoder,
                       JwtService jwtService){
        this.userRepository = userRepository;
        
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public void register(RegisterRequest request){
        String role = "";
        if(request.role.equals("ADMIN")){
            role = "ROLE_ADMIN";
        }else{
            role = "ROLE_USER";
        }


        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(role);
        userRepository.save(user);
        /*
        userRepository.save(user);
        if(userRepository.existsByEmail(request.email)){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.email);
        user.setPassword(encoder.encode(request.password));
        user.setRole("ROLE_USER");

        userRepository.save(user); */
        //return jwtService.generateToken(user.getEmail());
    }
    public String login(LogInRequest request){
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if(!encoder.matches(request.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtService.generateToken(user.getEmail());

    }
}
