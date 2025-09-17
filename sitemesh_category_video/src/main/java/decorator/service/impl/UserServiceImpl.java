package decorator.service.impl;

import decorator.dao.UserDao;
import decorator.dao.impl.UserDaoImpl;
import decorator.entity.User;
import decorator.service.UserService;

import java.util.List;

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
    
    @Override
    public User update(User u) {
    	if (u.getPassword() != null && !u.getPassword().startsWith("$2a$")) {
            String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
            u.setPassword(hashed);
        }
        return userDao.update(u);
    }
    
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
    
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }
    
    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
