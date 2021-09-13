package web.service;

import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getOneUser(Long id) {
        return userDao.getOneUser(id);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
