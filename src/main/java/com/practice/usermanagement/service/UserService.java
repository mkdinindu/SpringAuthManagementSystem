package com.practice.usermanagement.service;

import com.practice.usermanagement.dto.UserResponse;
import com.practice.usermanagement.dto.UserUpdateRequest;
import com.practice.usermanagement.entity.User;
import com.practice.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAll(){
        return userRepository.findAll().stream()
                .map(this::map)
                .toList();

    }
    public UserResponse getById(String id){
        return map(userRepository.findById(id).orElseThrow());
    }

    public UserResponse update(String id, UserUpdateRequest req){
        System.out.println("Updating user with id: " + id);
        User user = userRepository.findById(id).orElseThrow();
        user.setEmail(req.email);
        return map(userRepository.save(user));
    }
    public void delete(String id){
        userRepository.deleteById(id);
    }

    private UserResponse map(User user){
        UserResponse r = new UserResponse();
        r.id = user.getId();
        r.email = user.getEmail();
        r.role = user.getRole();
        return r;
    }
}
