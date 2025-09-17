package decorator.dao;

import java.util.List;

import decorator.entity.Category;

public interface CategoryDao {
	List<Category> findAll();
    Category findById(Long id);
    Category findByName(String name);
    Category create(Category c);
    Category update(Category c);
    void delete(Long id);
}
