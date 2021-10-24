package com.efutures.sample_product_app.repo;

import com.efutures.sample_product_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
//    List<Product> getProductsFromACategory(Long category_id);
}
