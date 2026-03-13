package com.javawithakash.springbootredis.service;

import com.javawithakash.springbootredis.entity.Product;
import com.javawithakash.springbootredis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RedisService redisService;

    @Override
    public List<Product> getProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer productId) {
        String key = "product:" + productId;
        Product cachedProduct = redisService.getCache(key, Product.class);
        if (cachedProduct != null) {
            return cachedProduct;
        }
        Product dbProduct = productRepository.findById(productId).orElse(null);
        if (dbProduct != null) {
            redisService.setCache(key, dbProduct, Duration.ofMinutes(10));
        }
        return dbProduct;
    }
}
