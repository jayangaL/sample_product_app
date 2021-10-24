package com.efutures.sample_product_app.controller;

import com.efutures.sample_product_app.impl.ProductRepositoryImpl;
import com.efutures.sample_product_app.model.Product;
import com.efutures.sample_product_app.model.ProductCategory;
import com.efutures.sample_product_app.service.CategoryService;
import com.efutures.sample_product_app.service.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductRepositoryImpl productRepositoryimpl;

    @RequestMapping(value = "/products/{category}",method = RequestMethod.GET)
    public List<Product> getAllProductsByCategory(@PathVariable(value = "category") String category_name){
        List<Product> products = new ArrayList<Product>();

        try{

            Long category_id = categoryService.getProductCategoryIdByName(category_name);
            ProductCategory productCategory = categoryService.getProductCategoryById(category_id);
            System.out.println(category_id);
            products = productRepositoryimpl.getProductsFromACategory(productCategory);
            System.out.println(products);
        //            categoryService.getProductCategoryById(category_id);


        }catch (Exception ex){
            System.out.println(ex);
        }
        return  products;
    }

    @RequestMapping(value = "products/premium",method = RequestMethod.POST)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    public List<Product> getAllPremiumProducts(){
        List<Product> products = new ArrayList<Product>();
        products = productRepositoryimpl.getPremiumProducts();
        return products;
    }

    @PostMapping(value = "products/save")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product){
        Product product1=new Product();
        try{
            System.out.println(product);
            productService.createNewProduct(product);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return new ResponseEntity<Product>(product1, HttpStatus.CREATED);

    }

    @PostMapping(value = "products/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product product1=new Product();
        try {
            productService.updateExistingProduct(product);

        }catch (Exception ex){
            System.out.println(ex);
        }
        return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "products/delete/{product_id}",method = RequestMethod.POST)
    public Long deleteProduct(@PathVariable(value = "product_id") Long product_id){
        try{
            Optional<Product> product = productService.getProductById(product_id);
            productService.deleteProduct(product_id);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return product_id;
    }
}
