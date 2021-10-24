package com.efutures.sample_product_app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    public Product(){}


    private String name;
    private String description;
    private Double price;

    public Product(Long product_id, String name, String description, Double price, Character status, com.efutures.sample_product_app.model.ProductCategory product_category, Date launch_date) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.product_category = product_category;
        this.launch_date = launch_date;
    }

    private Character status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category",nullable = false)
    @JsonProperty(value = "product_category",defaultValue = "1")
    private ProductCategory product_category;
    private Date launch_date;
    @OneToMany
    private Set<ProductComment> ProductComment;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }


    public Date getLaunch_date() {
        return launch_date;
    }

    public void setLaunch_date(Date launch_date) {
        this.launch_date = launch_date;
    }
    public ProductCategory getCategory() {
        return product_category;
    }

    public void setCategory(ProductCategory category) {
        this.product_category = category;
    }

}
