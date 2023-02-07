package com.zlatan.api.service;

import com.zlatan.api.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProduct();

    boolean deleteProduct(Long id);

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);
}
