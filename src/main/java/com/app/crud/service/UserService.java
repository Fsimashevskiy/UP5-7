package com.app.crud.service;

import com.app.crud.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(int id);
    User findUserByIdContains(int id);
    void save(User user);
    void delete(int id);
}
