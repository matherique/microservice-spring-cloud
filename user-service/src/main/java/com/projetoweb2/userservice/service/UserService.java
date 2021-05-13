package com.projetoweb2.userservice.service;

import com.projetoweb2.userservice.models.User;
import com.projetoweb2.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class UserService implements UserServiceInterface {
    @Autowired
    public UserRepository userRepository;

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userDB = getUser(id);
        if (userDB == null) {
            return null;
        }
        userDB.setId(id);
        userDB.setName(user.getName());
        userDB.setUsername(user.getUsername());
        userDB.setEmail(user.getEmail());
        // TODO: encrypt password
        userDB.setPassword(user.getPassword());
        userDB.setCreatedAt(user.getCreatedAt());
        userDB.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
