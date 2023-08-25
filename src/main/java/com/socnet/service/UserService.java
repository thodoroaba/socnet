package com.socnet.service;

import com.socialnetwork.app.model.User;
import com.socialnetwork.app.repo.UserRepo;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService instance;


    private UserService() { }

    public static UserService getInstance() {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public List<User> getAllUsers() throws SQLException {
        return UserRepo.getInstance().getAllUsers();
    }
}
