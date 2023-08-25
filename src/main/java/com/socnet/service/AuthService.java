package com.socnet.service;

import com.socialnetwork.app.repo.UserRepo;

import java.sql.SQLException;

public class AuthService {
    private static AuthService instance;

    private AuthService() {

    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public boolean checkAuth(String username, String password) throws SQLException {
        boolean result = false;
        result = UserRepo.getInstance().checkAuth(username, password);
        return result;
    }
}
