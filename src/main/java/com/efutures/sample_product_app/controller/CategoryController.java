package com.efutures.sample_product_app.controller;

import com.efutures.sample_product_app.model.ProductCategory;
import com.efutures.sample_product_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void createCategory(@RequestBody ProductCategory productCategory){
        categoryService.createCategory(productCategory);
    }

}
