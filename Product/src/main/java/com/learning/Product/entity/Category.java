package com.learning.Product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    cascade = CascadeType.ALL taki for eg: agar electronics ka category delete karenge toh uske products bhi delete ho jaye
    private List<Product> products = new ArrayList<>();
}
