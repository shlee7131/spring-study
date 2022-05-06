package com.example.doubleEntryBooking.usecase;

import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.entity.UserEntity;
import com.example.doubleEntryBooking.entity.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService implements UserServiceInputPort{
    private final UserEntity userEntity;

    @Autowired
    public UserService(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public User createUser(String id, String pw) {
        return new User(id,pw);
    }

    public void addUser(String id, String pw) throws RuntimeException {
        User user = createUser(id, pw);
        if (userEntity.getUserById(id) == null) {
            userEntity.addUser(user);
        } else throw new RuntimeException("이미 등록된 회원입니다");
    }

    public User getUser(User user) throws NoSuchElementException {
        UserValidation userValidation = userEntity.validateUser(user);
        if ( userValidation == UserValidation.SUCCESS) {
            User userById = userEntity.getUserById(user.getId());
            return userById;
        } else {
            switch(userValidation){
                case ID_FAIL:
                    throw new NoSuchElementException("아이디가 맞지 않습니다");
                case PW_FAIL:
                    throw new NoSuchElementException("비밀번호가 맞지 않습니다");
            }
            return null;
        }
    }
}
