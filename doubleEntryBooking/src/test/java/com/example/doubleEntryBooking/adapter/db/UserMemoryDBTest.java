package com.example.doubleEntryBooking.adapter.db;

import com.example.doubleEntryBooking.adapter.db.repository.UserRepository;
import com.example.doubleEntryBooking.entity.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserMemoryDBTest {
    UserRepository userRepository;

    @BeforeEach
    void beforeEach(){
        userRepository = new UserMemoryDB();
    }

    @Test
    @DisplayName("회원 등록")
    void addUser(){
        String id = "temp";
        String pw = "temp";
        User user = new User(id,pw);
        userRepository.addUser(user);
        User byId = userRepository.findById(id);
        assertThat(user).isEqualTo(byId);
    }

    @Test
    @DisplayName("회원 중복 등록 예외 발생")
    void addUserDuplicate(){
        String id = "temp";
        String pw = "temp";
        User user = new User(id,pw);
        assertThrows(RuntimeException.class, () -> {
            userRepository.addUser(user);
            userRepository.addUser(user);
        });
    }

    @Test
    @DisplayName("없는 회원 조회")
    void findUserNotExist(){
        String id = "temp";
        String pw = "temp";
        assertThat(userRepository.findById(id)).isEqualTo(null);
    }

}