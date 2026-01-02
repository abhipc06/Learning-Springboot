package com.learning.Product.service.service_implementation;

import com.learning.Product.dto.CategoryDTO;
import com.learning.Product.dto.ProductDTO;
import com.learning.Product.entity.Category;
import com.learning.Product.entity.Product;
import com.learning.Product.exception.CategoryNotFoundException;
import com.learning.Product.mapper.ProductMapper;
import com.learning.Product.repository.CategoryRepo;
import com.learning.Product.repository.ProductRepo;
import com.learning.Product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;
    public ProductServiceImpl(ProductRepo productRepo,CategoryRepo categoryRepo) {     // Constructor Injection
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {

       Category category=  categoryRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category id "+productDTO.getCategoryId() +" found!!"));

       //DTO -> entity
      Product product =  ProductMapper.toProductEntity(productDTO,category);
      product = productRepo.save(product);


//      Entity -> DTO
        return ProductMapper.toProductDTO(product);
    }

    @Override
    public List<ProductDTO> getALlProducts() {
        return productRepo.findAll().stream()
                .map(ProductMapper::toProductDTO).toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return ProductMapper.toProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        Category category = categoryRepo.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setName(productDTO.getName());
        product.setDescription(product.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepo.save(product);
        return ProductMapper.toProductDTO(product);
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        productRepo.deleteById(id);
        return "Product with id : "+id+" has been deleted";
    }
}
