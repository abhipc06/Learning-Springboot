package com.learning.Product.controller;

import com.learning.Product.dto.ProductDTO;
import com.learning.Product.service.service_implementation.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }



    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productServiceImpl.createProduct(productDTO), HttpStatus.CREATED);
    }

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productServiceImpl.getALlProducts(),HttpStatus.OK);
  }

  @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productServiceImpl.getProductById(id),HttpStatus.OK);
  }

@PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productServiceImpl.updateProduct(id,productDTO),HttpStatus.OK);
}

@DeleteMapping("/{id}")
        public ResponseEntity<String> deleteProduct(@PathVariable Long id){
            return new ResponseEntity<>(productServiceImpl.deleteProduct(id),HttpStatus.OK);
    }
}

