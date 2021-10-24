package com.efutures.sample_product_app.service;

import com.efutures.sample_product_app.model.Product;
import com.efutures.sample_product_app.model.ProductCategory;
import com.efutures.sample_product_app.repo.CategoryRepository;
import com.efutures.sample_product_app.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public void createCategory(ProductCategory productCategory){
        categoryRepository.save(productCategory);
    }

    public Long getProductCategoryIdByName(String category_name){
        ProductCategory productCategory;
        Long catgory_id = 0L;
        try{
            productCategory = categoryRepository.findByName(category_name);
            catgory_id = productCategory.getProduct_category_id();

        }catch (Exception ex){
            System.out.println(ex);
        }
//        ProductCategory productCategory = categoryRepository.getById(category_id);
//        Product productRepository.getById(product_id);


        return catgory_id;
    }

    public ProductCategory getProductCategoryById(Long id){
        return categoryRepository.getById(id);
    }
}
