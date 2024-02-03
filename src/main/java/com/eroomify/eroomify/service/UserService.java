package com.eroomify.eroomify.service;

import com.eroomify.eroomify.entity.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    List<User> getUsers();
    void deleteUser(String email);
    User getUser(String email);
}
