package com.socnet.repo;

import com.socnet.model.User;
import com.socnet.utils.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepo {
    private Connection connection;

    public static final String USER_USERNAME = "username";
    public static final String USER_ID = "id";
    public static final String USER_EMAIL = "email_address";
    public static final String USER_PIC = "profile_pic";
    public static final String USER_REG_DATE = "registered_on";
    public static final String USER_PASSWORD = "password";
    public static final String TABLE_USER = "user";

    @Autowired
    AppConfiguration config;

    public void init() throws SQLException {
        connection = DriverManager.getConnection(
                config.getDbUrl(),
                config.getDbName(),
                config.getDbPass()
        );
    }

    public boolean checkAuth(String username, String password) throws SQLException {
        boolean result = false;
        String query = String.format("SELECT * FROM user WHERE %s = '%s' AND %s = '%s';" ,
                USER_USERNAME,
                username,
                USER_PASSWORD,
                password);

        PreparedStatement ps = connection.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            result = true;
        }
        return result;
    }

    public List<User> getAllUsers() throws SQLException {

        List<User> userList = new ArrayList<>();
        String query = String.format("SELECT * FROM %s;", TABLE_USER);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            userList.add(User.builder()
                    .username(rs.getString(USER_USERNAME))
                    .id(rs.getString(USER_ID))
                    .emailAddress(rs.getString(USER_EMAIL))
                    .profilePic(rs.getString(USER_PIC))
                    .registeredOn(new Date(rs.getLong(USER_REG_DATE)))
                    .build()
            );

        }
        return userList;
    }
}
