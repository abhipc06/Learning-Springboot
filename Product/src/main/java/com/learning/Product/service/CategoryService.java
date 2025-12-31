package com.learning.Product.service;

import com.learning.Product.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    abstract CategoryDTO createCategory(CategoryDTO categoryDTO);
    abstract List<CategoryDTO> getAllCategories();
    abstract CategoryDTO getCategoryById(Long id);
    abstract String deleteCategory(Long id);
}
