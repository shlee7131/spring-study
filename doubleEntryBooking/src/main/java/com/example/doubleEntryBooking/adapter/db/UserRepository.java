package com.example.doubleEntryBooking.adapter.db;

import com.example.doubleEntryBooking.entity.domain.User;

public interface UserRepository {
    User findById(String id);
    void addUser(User user);
}
