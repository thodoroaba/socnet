package com.socnet.service;

import com.socnet.model.User;
import com.socnet.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public List<User> getAllUsers() throws SQLException {
        repo.init();
        return repo.getAllUsers();
    }

    public User getUserById(String userId) throws SQLException {
        repo.init();
        return repo.getUserById(userId);
    }
}
