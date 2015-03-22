package info.fges.blablacool.services;

import info.fges.blablacool.dao.UserDao;
import info.fges.blablacool.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Service
public class UserService extends ServiceInterface<User, Integer>
{
    @Autowired
    private UserDao userDao;

    public User findByEmail(String email)
    {
        return userDao.findByEmail(email);
    }

    @Override
    public User findById(Integer integer) {
        return userDao.findById(integer);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user)
    {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void deleteById(Integer integer) {
        userDao.deleteById(integer);
    }

    public boolean nicknameAlreadyExists(String nickname)
    {
        return userDao.nicknameAlreadyExists(nickname);
    }

    public boolean emailAlreadyExists(String email)
    {
        return userDao.emailAlreadyExists(email);
    }
}
