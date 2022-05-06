package com.example.doubleEntryBooking.adapter.web;


import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.usecase.UserServiceInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.NoSuchElementException;

@Controller
public class UserController{
    private final UserServiceInputPort inputPort;

    @Autowired
    public UserController(UserServiceInputPort userServiceInputPort){
        this.inputPort = userServiceInputPort;
    }

    public User getUser(User user) {
        try {
            User targetUser = inputPort.getUser(user);
            return targetUser;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String addUser(User user){
        try {
            inputPort.addUser(user.getId(), user.getId());
            return "SUCCESS";
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return "FAIL";
        }
    }
}
