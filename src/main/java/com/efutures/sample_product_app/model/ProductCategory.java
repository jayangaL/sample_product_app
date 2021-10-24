package com.efutures.sample_product_app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_category_id;
    private String name;
    private String description;
    @OneToMany
    private Set<Product> Product;

    public ProductCategory() {
    }

    public ProductCategory(Long product_category_id) {
        this.product_category_id = product_category_id;
    }

    public Long getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(Long product_category_id) {
        this.product_category_id = product_category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
