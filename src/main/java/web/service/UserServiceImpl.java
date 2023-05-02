package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.models.User;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }


    @Override
    public void save(User user) {
    userDao.save(user);
    }


    @Override
    public void removeUserById(long id) {
    userDao.removeUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }


    @Override
    public void update(long id, User user) {
    userDao.update(id, user);
    }
}
