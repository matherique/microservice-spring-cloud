package com.projetoweb2.userservice.service;

import com.projetoweb2.userservice.models.User;
import com.projetoweb2.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

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
        user.setPassword(encoder.encode(user.getPassword()));
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
        userDB.setName(user.getName());
        userDB.setUsername(user.getUsername());
        userDB.setEmail(user.getEmail());
        userDB.setPassword(encoder.encode(user.getPassword()));
        userDB.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(userDB);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) return false;

        boolean isValidPassword = encoder.matches(password, user.getPassword());

        if (!isValidPassword) return false;

        // TODO: create token
        return true;
    }

}
