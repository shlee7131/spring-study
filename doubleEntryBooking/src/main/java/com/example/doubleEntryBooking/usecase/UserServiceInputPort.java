package com.example.doubleEntryBooking.usecase;

import com.example.doubleEntryBooking.entity.domain.User;

public interface UserServiceInputPort {
    User createUser(String id, String pw);
    void addUser(String id, String pw);
    User getUser(User user);
}
