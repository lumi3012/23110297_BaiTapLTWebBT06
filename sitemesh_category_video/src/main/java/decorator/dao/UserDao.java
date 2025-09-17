package decorator.dao;

import java.util.List;

import decorator.entity.User;

public interface UserDao {
	User findById(Long id);
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
    User create(User u);
    User update(User u);
    void delete(Long id);
}
