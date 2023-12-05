package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void createUserTable();
    void saveUser(User user);
    void removeUserById(long id);
    List<User> getUsers();
    User getUserById(long id);
    void updateUser(long id, User createUser);
}
