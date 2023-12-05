package com.vik.springtask.MicroserviceTask1.service;

import com.vik.springtask.MicroserviceTask1.model.User;
import java.util.List;

public interface UserService {
    void createUserTable();
    void saveUser(User user);
    void removeUserById(long id);
    List<User> getUsers();
    User getUserById(long id);
    void updateUser(long id, User createUser);
}
