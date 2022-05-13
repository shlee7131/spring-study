package com.example.doubleEntryBooking.entity;

import com.example.doubleEntryBooking.adapter.db.repository.UserRepository;
import com.example.doubleEntryBooking.entity.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntity {
    private final UserRepository userRepository;

    public UserEntity(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String id) {
        User user = userRepository.findById(id);
        return user;
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public UserValidation validateUser(User user){
        String id = user.getId();
        User byId = userRepository.findById(id);

        if (byId == null) return UserValidation.ID_FAIL;
        else if (!byId.getPw().equals(user.getPw())) return UserValidation.PW_FAIL;
        else return UserValidation.SUCCESS;
    }
}
