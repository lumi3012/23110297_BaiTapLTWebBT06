package decorator.service;

import decorator.entity.User;

public interface UserService {
	User register(User u);
    User login(String username, String password);
    User findByUsername(String username);
}
