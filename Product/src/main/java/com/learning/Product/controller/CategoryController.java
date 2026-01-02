package com.learning.Product.controller;


import com.learning.Product.dto.CategoryDTO;
import com.learning.Product.exception.CategoryAlreadyExistsException;
import com.learning.Product.service.service_implementation.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return new ResponseEntity<>(categoryServiceImpl.getAllCategories(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
           CategoryDTO savedCategory = categoryServiceImpl.createCategory(categoryDTO);
           return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryServiceImpl.getCategoryById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        return new ResponseEntity<>(categoryServiceImpl.deleteCategory(id),HttpStatus.OK);
    }
}
