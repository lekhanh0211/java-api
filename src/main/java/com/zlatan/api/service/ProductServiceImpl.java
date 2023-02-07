package com.zlatan.api.service;

import com.zlatan.api.entity.ProductEntity;
import com.zlatan.api.model.Product;
import com.zlatan.api.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepo){
        this.productRepository = productRepo;
    }
    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product,productEntity);
        productRepository.save(productEntity);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<Product> products = productEntities.stream().map(pro -> new Product(
                pro.getId(),
                pro.getName(),
                pro.getCatId(),
                pro.getPrice(),
                pro.getDesc(),
                pro.getSpecification(),
                pro.isHighlight(),
                pro.isStatus()
        )).collect(Collectors.toList());
        return products;
    }


    @Override
    public boolean deleteProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        productRepository.delete(productEntity);
        return true;
    }

    @Override
    public Product getProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        Product product = new Product();
        BeanUtils.copyProperties(productEntity,product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        ProductEntity productEntity = productRepository.findById(id).get();

        productEntity.setName(product.getName());
        productEntity.setDesc(product.getDesc());
        productEntity.setPrice(product.getPrice());
        productEntity.setHighlight(product.isHighlight());
        productEntity.setCatId(product.getCatId());
        productEntity.setSpecification(product.getSpecification());
        productEntity.setStatus(product.isStatus());

        productRepository.save(productEntity);
        return product;
    }
}
