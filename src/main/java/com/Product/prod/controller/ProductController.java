package com.Product.prod.controller;

import com.Product.prod.models.ProductEntity;
import com.Product.prod.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/products")
    private ResponseEntity<List<ProductEntity>> getAllProds(){
        return ResponseEntity.ok().body(this.productServices.getProducts());
    }

    @GetMapping("/products/{prodId}")
    private ProductEntity getProductById(@PathVariable long prodId) {
        return this.productServices.getProductById(prodId);
    }

    @PostMapping("/createProduct")
    private ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity productEntity){
        return ResponseEntity.ok().body(this.productServices.createProduct(productEntity));
    }

    @PutMapping("/updateProduct/{prodId}")
    private ResponseEntity<ProductEntity> updateProduct(@PathVariable long prodId, @RequestBody ProductEntity productEntity){
        productEntity.setProdId(prodId);
        return ResponseEntity.ok().body(this.productServices.updateProduct(productEntity));
    }

    @DeleteMapping("/deleteProduct/{prodId}")
    private HttpStatus deleteProd(@PathVariable long prodId){
        this.productServices.deleteProduct(prodId);
        return HttpStatus.OK;
    }

}
