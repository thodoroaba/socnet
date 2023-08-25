package com.socnet.controller;

import com.socnet.model.User;
import com.socnet.service.UserService;
import com.socnet.utils.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AppConfiguration config;

    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> getAllUsers(){
        System.out.println(config.getDbName());
        System.out.println(config.getDbPass());
        System.out.println(config.getDbUrl());
        List<User> userList = null;
        try {
            userList = userService.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error!!");
        }
       return ResponseEntity
               .ok()
               .body(userList);
    }
}
