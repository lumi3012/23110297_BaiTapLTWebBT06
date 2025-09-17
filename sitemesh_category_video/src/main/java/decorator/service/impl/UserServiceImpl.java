package decorator.service.impl;

import decorator.dao.UserDao;
import decorator.dao.impl.UserDaoImpl;
import decorator.entity.User;
import decorator.service.UserService;
import org.mindrot.jbcrypt.BCrypt;


public class UserServiceImpl implements UserService {
	private final UserDao userDao = new UserDaoImpl();

    @Override
    public User register(User u) {
        if (userDao.findByUsername(u.getUsername()) != null) {
            throw new RuntimeException("username.exists");
        }
        if (userDao.findByEmail(u.getEmail()) != null) {
            throw new RuntimeException("email.exists");
        }
        u.setPassword(BCrypt.hashpw(u.getPassword(), BCrypt.gensalt()));
        return userDao.create(u);
    }

    @Override
    public User login(String username, String password) {
        User u = userDao.findByUsername(username);
        if (u == null) return null;
        return BCrypt.checkpw(password, u.getPassword()) ? u : null;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
