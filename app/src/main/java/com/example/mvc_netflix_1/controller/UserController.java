package com.example.mvc_netflix_1.controller;

import com.example.mvc_netflix_1.MainActivity;
import com.example.mvc_netflix_1.model.UserWS;
import com.example.mvc_netflix_1.model.pojo.User;

public class UserController {
    private UserWS model;
    private MainActivity view;
    private User user;

    public UserController(UserWS model, MainActivity view) {
        this.model = model;
        this.view = view;
    }

    public void newUser() {
        user = model.getUserWS();
        view.printUser(user);
    }

    public User getUser(){
        return user;
    }


}
