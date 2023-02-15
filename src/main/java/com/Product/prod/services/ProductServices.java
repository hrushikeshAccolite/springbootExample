package com.Product.prod.services;

import com.Product.prod.models.ProductEntity;

import java.util.List;

public interface ProductServices {
    ProductEntity createProduct(ProductEntity prod);

    ProductEntity updateProduct(ProductEntity prod);

    List<ProductEntity> getProducts();

    ProductEntity getProductById(Long prodId);

    void deleteProduct(Long prodId);
}
