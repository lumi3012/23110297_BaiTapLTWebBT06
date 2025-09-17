package decorator.dao;

import decorator.entity.User;

public interface UserDao {
	User findById(Long id);
    User findByUsername(String username);
    User findByEmail(String email);
    User create(User u);
}
