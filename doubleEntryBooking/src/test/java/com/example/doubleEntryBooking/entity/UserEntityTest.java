package com.example.doubleEntryBooking.entity;

import com.example.doubleEntryBooking.adapter.db.UserMemoryDB;
import com.example.doubleEntryBooking.adapter.db.repository.UserRepository;
import com.example.doubleEntryBooking.entity.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserEntityTest {
    UserRepository userRepository;
    UserEntity userEntity;

    @BeforeEach
    void beforeEach(){
        userRepository = new UserMemoryDB();
        userEntity = new UserEntity(userRepository);
    }


    @Test
    @DisplayName("회원 정보 일치")
    void validateUserSuccess() {
        User user = new User("temp","temp");
        userRepository.addUser(user);
        UserValidation userValidation = userEntity.validateUser(user);
        assertThat(userValidation).isEqualTo(UserValidation.SUCCESS);
    }

    @Test
    @DisplayName("회원 정보 비밀번호 불일치")
    void validateUserFailPw() {
        User user = new User("temp","temp");
        User userFail = new User("temp","fail");
        userRepository.addUser(user);
        UserValidation userValidation = userEntity.validateUser(userFail);
        assertThat(userValidation).isEqualTo(UserValidation.PW_FAIL);
    }

    @Test
    @DisplayName("회원 정보 아이디 불일치")
    void validateUserFailId() {
        User user = new User("temp","temp");
        User userFail = new User("fail","temp");
        userRepository.addUser(user);
        UserValidation userValidation = userEntity.validateUser(userFail);
        assertThat(userValidation).isEqualTo(UserValidation.ID_FAIL);
    }
}