package com.tsm.user.controller;

import com.tsm.user.entiry.User;
import com.tsm.user.model.RequestModel;
import com.tsm.user.model.ResponseModel;
import com.tsm.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }
    @PostMapping("/saveUserAndAddress")
    public ResponseModel saveUserAndAddress(@RequestBody RequestModel request) {
        log.info("Inside saveUserAndAddress of UserController");
        return userService.saveUserAndAddress(request);
    }

    @GetMapping("/{id}")
    public ResponseModel getUserById(@PathVariable Integer id) {
        log.info("Inside getUserById of UserController");
        return userService.getUserById(id);
    }


}
