package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
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

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void updateUser(Long id, User user) {
        userDao.updateUser(id, user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
