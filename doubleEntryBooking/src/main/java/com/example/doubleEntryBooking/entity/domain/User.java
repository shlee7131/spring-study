package com.example.doubleEntryBooking.entity.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private final String id;
    private String pw;

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
