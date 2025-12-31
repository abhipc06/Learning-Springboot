package com.learning.Product.service;

import com.learning.Product.dto.CategoryDTO;
import com.learning.Product.dto.ProductDTO;
import com.learning.Product.repository.ProductRepo;

import java.util.List;

public interface ProductService {

    abstract ProductDTO createProduct(ProductDTO productDTO);
    abstract List<ProductDTO> getALlProducts();
    abstract ProductDTO getProductById(Long id);
    abstract ProductDTO updateProduct(Long id, ProductDTO productDTO);
    abstract String deleteProduct(Long id);
}
