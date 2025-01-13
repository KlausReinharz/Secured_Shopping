package com.Klaus.Secured_Shopping.service.category;

import com.Klaus.Secured_Shopping.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category>getAllCategory();
    Category addCategory(Category category);
    void deleteCategoryById(Long id);
    Category updateCategory(Category category, Long id);

}
