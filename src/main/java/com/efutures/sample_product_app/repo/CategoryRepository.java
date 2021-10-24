package com.efutures.sample_product_app.repo;

import com.efutures.sample_product_app.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<ProductCategory,Long> {
    ProductCategory findByName(String name);
}
