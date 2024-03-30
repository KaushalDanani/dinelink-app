package com.example.dinelink.model;

public class User {

    private String user_email;
    private String user_name;

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "User{" +
                ", user_email='" + user_email + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }

}
