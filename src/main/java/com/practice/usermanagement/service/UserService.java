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
    public UserResponse getById(Long id){
        return map(userRepository.findById(id).orElseThrow());
    }

    public UserResponse update(Long id, UserUpdateRequest req){
        User user = userRepository.findById(id).orElseThrow();
        user.setEmail(req.email);
        return map(userRepository.save(user));
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    private UserResponse map(User user){
        UserResponse r = new UserResponse();
        r.id = user.getId();
        r.email = user.getEmail();
        r.role = user.getRoles().stream()
                .map(role -> role.getName())
                .findFirst()
                .orElse(null);
        return r;
    }
}
