package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getOneUser(int id);
    void addUser(User user);
    void updateUser(int id, User user);
    void deleteUser(int id);
}
