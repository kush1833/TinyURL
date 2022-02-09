package com.kushagra.tinyURL.model;
import java.util.Date;

public class User {
    private int userId;
    private String name;
    private String email;
    private Date createdAt;
    private Date lastLoginAt;
    static int USER_NO = 0;

    public User(String name, String email){
        this.name = name;
        this.email = email;
        this.createdAt = new Date();
        this.lastLoginAt = new Date();
        this.userId = generateUserId();
    }

    public void updateLastLogin(){
        this.lastLoginAt = new Date();
    }

    public int getUserId(){
        return this.userId;
    }

    public String getEmail(){
        return this.email;
    }
    private int generateUserId(){
        USER_NO = USER_NO + 1;
        return USER_NO;
    }
}