package com.Product.prod.services;

import com.Product.prod.exception.ProductException;
import com.Product.prod.models.ProductEntity;
import com.Product.prod.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductServices{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity prod) {
        return productRepository.save(prod);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity prod) {
        Optional<ProductEntity> prodObj = this.productRepository.findById(prod.getProdId());

        if(prodObj.isPresent()){
            ProductEntity prodUpdate = prodObj.get();
            prodUpdate.setProdName(prod.getProdName());
            prodUpdate.setProdPrice(prod.getProdPrice());
            return this.productRepository.save(prodUpdate);
        } else {
            throw new ProductException("Product not found with id " + prod.getProdId());
        }
    }

    @Override
    public List<ProductEntity> getProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(Long prodId) {
        Optional<ProductEntity> prodObj = this.productRepository.findById(prodId);
        if(prodObj.isPresent()){
            return prodObj.get();
        } else {
            throw new ProductException("Product not found with id " + prodId);
        }
    }

    @Override
    public void deleteProduct(Long prodId) {
        Optional<ProductEntity> prodObj = this.productRepository.findById(prodId);
        if(prodObj.isPresent()){
            this.productRepository.deleteById(prodId);
        } else {
            throw new ProductException("Product not found with id " + prodId);
        }
    }
}
