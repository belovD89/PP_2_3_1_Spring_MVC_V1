package web.servise;

import web.model.User;
import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    void saveUser(User user);

    void deleteById(Long id);

    void updateUser(User user);
}
