package web.servise;

import org.springframework.stereotype.Service;
import web.dao.*;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl (UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updateUser(User user) {

    }
}
