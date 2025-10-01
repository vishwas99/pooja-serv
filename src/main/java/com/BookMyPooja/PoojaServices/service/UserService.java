package com.BookMyPooja.PoojaServices.service;

import com.BookMyPooja.PoojaServices.model.User;
import com.BookMyPooja.PoojaServices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getUsers() {
       return this.userRepository.findAll();
    }
}
