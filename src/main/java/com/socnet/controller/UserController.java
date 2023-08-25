package com.socnet.controller;

import com.socnet.model.User;
import com.socnet.service.UserService;
import com.socnet.utils.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> getAllUsers(){
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(
            @PathVariable(value = "id") String userId
    ){
        User user = null;
        try {
            user = userService.getUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error!!");
        }
        if(user == null){
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return ResponseEntity
                .ok()
                .body(user);
    }
}
