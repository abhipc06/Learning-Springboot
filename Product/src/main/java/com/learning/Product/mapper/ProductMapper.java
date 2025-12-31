package com.learning.Product.mapper;

import com.learning.Product.dto.ProductDTO;
import com.learning.Product.entity.Category;
import com.learning.Product.entity.Product;

public class ProductMapper {

    // Entity to ProductDTO
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

   // DTO to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }

//    public static Product toProductEntity(ProductDTO dto, Category category) {        just for experimenting
//        return new Product(
//                category,                 // Category
//                dto.getDescription(),     // String description
//                dto.getId(),              // Long id
//                dto.getName(),            // String name
//                dto.getPrice()            // Double price
//        );
//    }


    }
