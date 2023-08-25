package com.socnet.controller;

import com.socnet.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    public List<User> getAllUsers(){

        return null;
    }
}
