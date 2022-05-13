package com.example.doubleEntryBooking.adapter.web;

import com.example.doubleEntryBooking.adapter.db.UserMemoryDB;
import com.example.doubleEntryBooking.adapter.db.repository.UserRepository;
import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.entity.UserEntity;
import com.example.doubleEntryBooking.usecase.UserService;
import com.example.doubleEntryBooking.usecase.UserServiceInputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserControllerTest {

    UserController userController;


    @BeforeEach
    void beforeEach(){
        UserRepository userRepository = new UserMemoryDB();
        UserEntity userEntity = new UserEntity(userRepository);
        UserServiceInputPort inputPort = new UserService(userEntity);
        userController = new UserController(inputPort);
    }

    @Test
    @DisplayName("회원 추가")
    void addUser(){
        User user = new User("temp","temp");
        String result = userController.addUser(user);
        User target = userController.getUser(new User("temp", "temp"));
        assertThat(result).isEqualTo("SUCCESS");
        assertThat(target).isNotNull();
    }

    @Test
    @DisplayName("회원 중복 추가")
    void addUserDuplicate() {
        User user = new User("temp","temp");
        userController.addUser(user);
        String result = userController.addUser(user);
        assertThat(result).isEqualTo("FAIL");
    }

    @Test
    @DisplayName("회원 조회 성공")
    void getUser() {
        User user = new User("temp","temp");
        userController.addUser(user);
        User target = userController.getUser(new User("temp","temp"));
        assertThat(target).isNotNull();
        assertThat(target.getId()).isEqualTo("temp");
        assertThat(target.getPw()).isEqualTo("temp");
    }

    @Test
    @DisplayName("회원 조회 비밀번호 실패")
    void getUserFailPw() {
        User user = new User("temp","temp");
        userController.addUser(user);
        User target = userController.getUser(new User("temp", "fail"));
        assertThat(target).isNull();

    }

    @Test
    @DisplayName("회원 조회 아이디 실패")
    void getUserFailId() {
        User user = new User("temp","temp");
        userController.addUser(user);
        User target = userController.getUser(new User("fail", "temp"));
        assertThat(target).isNull();
    }
}