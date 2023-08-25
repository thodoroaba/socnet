package com.socnet.model;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
public class User {

    private String id;
    private String username;
    private String password;
    private String profilePic;
    private String emailAddress;
    private Date registeredOn;

}