package com.example.doubleEntryBooking.usecase;

import com.example.doubleEntryBooking.adapter.db.UserMemoryDB;
import com.example.doubleEntryBooking.adapter.db.UserRepository;
import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserServiceInputPort inputPort;

    @BeforeEach
    void beforeEach(){
        UserRepository userRepository = new UserMemoryDB();
        UserEntity userEntity = new UserEntity(userRepository);
        inputPort = new UserService(userEntity);
    }

    @Test
    @DisplayName("회원 추가")
    void addUser(){
        inputPort.addUser("temp", "temp");
        User user = inputPort.getUser(new User("temp", "temp"));
        assertThat(user).isNotNull();
    }

    @Test
    @DisplayName("회원 중복 추가")
    void addUserDuplicate() {
        assertThrows(RuntimeException.class, () -> {
            inputPort.addUser("temp", "temp");
            inputPort.addUser("temp", "temp");
        });
    }

    @Test
    @DisplayName("회원 조회 성공")
    void getUser() {
        inputPort.addUser("temp", "temp");
        User target = inputPort.getUser(new User("temp","temp"));
        assertThat(target).isNotNull();
        assertThat(target.getId()).isEqualTo("temp");
        assertThat(target.getPw()).isEqualTo("temp");
    }

    @Test
    @DisplayName("회원 조회 비밀번호 실패")
    void getUserFailPw() {
        inputPort.addUser("temp", "temp");
        assertThrowsExactly(NoSuchElementException.class, ()->{
            inputPort.getUser(new User("fail","temp"));
        },"비밀번호가 맞지 않습니다");
    }

    @Test
    @DisplayName("회원 조회 아이디 실패")
    void getUserFailId() {
        inputPort.addUser("temp", "temp");
        assertThrowsExactly(NoSuchElementException.class, ()->{
            inputPort.getUser(new User("fail","temp"));
        },"아이디가 맞지 않습니다");
    }
}