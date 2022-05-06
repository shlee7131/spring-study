package com.example.doubleEntryBooking.adapter.db;

import com.example.doubleEntryBooking.entity.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class UserMemoryDB implements UserRepository {
    private final Map<String, User> map = new HashMap<>();

    @Override
    public User findById(String id) {
        User user = map.get(id);
        return user;
    }

    @Override
    public void addUser(User user) {
        String id = user.getId();
        if ( findById(id) == null) {
            map.put(id, user);
        } else throw new RuntimeException();
    }
}
