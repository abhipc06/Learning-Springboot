package com.learning.Product.service.service_implementation;


import com.learning.Product.dto.CategoryDTO;
import com.learning.Product.entity.Category;
import com.learning.Product.mapper.CategoryMapper;
import com.learning.Product.repository.CategoryRepo;
import com.learning.Product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepo.save(category);
        return CategoryMapper.toCategoryDTO(category);

    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepo.findAll()
                .stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return CategoryMapper.toCategoryDTO(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        categoryRepo.deleteById(id);
        return "Category with id : "+ id + " has been deleted";
    }
}
