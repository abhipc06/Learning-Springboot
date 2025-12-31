package com.learning.Product.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDTO> products;

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryDTO(Long id, String name, List<ProductDTO> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public CategoryDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }
}
