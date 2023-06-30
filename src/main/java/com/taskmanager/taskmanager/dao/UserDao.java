package com.taskmanager.taskmanager.dao;



import com.taskmanager.taskmanager.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    List<User> getAllUser();

    User getById(Long id);
}
