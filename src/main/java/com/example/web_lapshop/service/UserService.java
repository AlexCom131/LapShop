package com.example.web_lapshop.service;

import com.example.web_lapshop.entity.LapTopEntity;
import com.example.web_lapshop.entity.UserEntity;
import com.example.web_lapshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class   UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserEntity newUser) {
        if (userRepository.existsByUsername(newUser.getUsername())) {
            throw new RuntimeException("Це ім'я користувача вже зайняте!");
        }
        userRepository.save(newUser);
    }

    public boolean checkUser(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    public LapTopEntity findById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
}
