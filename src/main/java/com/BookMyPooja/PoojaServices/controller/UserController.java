package com.BookMyPooja.PoojaServices.controller;

import com.BookMyPooja.PoojaServices.model.User;
import com.BookMyPooja.PoojaServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> fetchAll() {
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }
}
