package decorator.service;

import java.util.List;

import decorator.entity.User;

public interface UserService {
	User register(User u);
	User update(User u);
	void delete(Long id);
    User login(String username, String password);
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
    User findById(Long id);
}
