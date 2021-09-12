package com.rest.template.springbootresttemplateex.controller;

import com.rest.template.springbootresttemplateex.model.PostUser;
import com.rest.template.springbootresttemplateex.model.User;
import com.rest.template.springbootresttemplateex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController<T> {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllProducts(){

        return userService.getAllUsers();
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody PostUser postUser){
        return userService.addUser(postUser);
    }

}
