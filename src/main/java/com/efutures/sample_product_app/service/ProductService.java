package com.efutures.sample_product_app.service;

import com.efutures.sample_product_app.model.Product;
import com.efutures.sample_product_app.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProducts(){
        return productRepository.findAll();
    };

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }


    public void createNewProduct(Product product){
        productRepository.save(product);

    }

    public Optional<Product> updateExistingProduct(Product product){
        Optional<Product> prev = productRepository.findById(product.getProduct_id());
        System.out.println(prev);
        productRepository.save(product);
        Optional<Product> post = productRepository.findById(product.getProduct_id());
        System.out.println(post);

        return post;
    }

    public Long deleteProduct(Long product){
        try{
            Product product1 = productRepository.getById(product);
            product1.setStatus('D');
            if(product1 != null){
                productRepository.save(product1);
            }else{
                System.out.println("Such product Do not Exist!");
            }

        }catch (Exception ex){
            System.out.println(ex);
        }
        return product;

    }



}
