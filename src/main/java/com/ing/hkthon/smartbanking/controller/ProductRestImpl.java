/*
 *  Copyright (c) 2020 Andree Hagelstein, Maik Schulze, Deutsche Telekom AG. All Rights Reserved.
 *  
 *  Filename: ProductRestImpl.java
 */
package com.ing.hkthon.smartbanking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hkthon.smartbanking.model.Product;
import com.ing.hkthon.smartbanking.service.IProductService;
 
/**
 * The Class ProductRestImpl.
 * @author pushpank
 */
@RestController
@RequestMapping("/api/products")
public class ProductRestImpl {
 
    @Autowired
    private  IProductService productService;
    
    private Logger logger=LoggerFactory.getLogger(ProductRestImpl.class);
     
    
    /**
     * Gets the all products.
     *
     * @param productGroupId the product group id
     * @return the all products
     */
    @GetMapping("/findByProductGroup/{productGroupId}")
    public ResponseEntity<List<Product>> findByProductGroup(@PathVariable(name="productGroupId") int productGroupId) 
    {
    	logger.info("@method findByProductGroup @param productGroupId "+productGroupId);
        return productService.getAllProductsByProductGroupId(productGroupId);
    }
    
    @GetMapping("/{productId}")
    public ResponseEntity<Product> findByProductId(@PathVariable(name="productId") Integer productId) {
        
    	logger.info("@method findByProductId @param productId "+productId);
    	return productService.findProductByProductId(productId);
    }
    
}
