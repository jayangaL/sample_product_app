package com.efutures.sample_product_app.impl;

import com.efutures.sample_product_app.model.Product;
import com.efutures.sample_product_app.model.ProductCategory;
import com.efutures.sample_product_app.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class ProductRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;

    @SuppressWarnings("unused")
    public List<Product> getProductsFromACategory(ProductCategory category){
        Query query = entityManager.createQuery("FROM Product p where p.product_category=:id");
        query.setParameter("id",category);
        List<Product> products = query.getResultList();

        return products;

    }

    @SuppressWarnings("unused")
    public List<Product> getPremiumProducts(){
        Query query = entityManager.createQuery("FROM Product p where p.price>=:id");
        query.setParameter("id",500.00);
        List<Product> products = query.getResultList();

        return products;

    }
}
