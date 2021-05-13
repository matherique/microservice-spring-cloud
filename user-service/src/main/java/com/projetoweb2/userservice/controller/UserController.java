package com.projetoweb2.userservice.controller;

import com.projetoweb2.userservice.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public ResponseEntity<List<User>> index() {
        List<User> users = new ArrayList<User>();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

}
