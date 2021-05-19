package com.projetoweb2.userservice.service;

import com.projetoweb2.userservice.models.User;

import java.util.List;

public interface UserServiceInterface {
    public List<User> listAllUsers();
    public User getUser(Long id);
    public User createUser(User user);
    public User updateUser(Long id, User user);
    public void deleteUser(Long id);
    public boolean login(String email, String password);
}
