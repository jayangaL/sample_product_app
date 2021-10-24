package com.efutures.sample_product_app.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ProductComment")
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_comment_id;
    private String comment;
    private Timestamp created_at;

//    public int getProduct_id() {
//        return product_id;
//    }
//
//    public void setProduct_id(int product_id) {
//        this.product_id = product_id;
//    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Product",nullable = false)
    private Product Product;

    public Product getProduct() {
        return Product;
    }

    public void setProduct(Product product) {
        this.Product = product;
    }

    //    private int product_product_id;

    public Long getProduct_comment_id() {
        return product_comment_id;
    }

    public void setProduct_comment_id(Long product_comment_id) {
        this.product_comment_id = product_comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }




}
