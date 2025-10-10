package com.BookMyPooja.PoojaServices.controller;

import com.BookMyPooja.PoojaServices.entity.User;
import com.BookMyPooja.PoojaServices.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserRepository userRepository;

    private UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
