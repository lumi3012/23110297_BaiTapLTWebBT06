package decorator.service;

import java.util.List;

import decorator.entity.Category;

public interface CategoryService {
	List<Category> list();
    Category create(Category c);
    Category update(Category c);
    void delete(Long id);
    Category findById(Long id);
}
