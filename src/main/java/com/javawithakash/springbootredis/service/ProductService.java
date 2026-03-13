package com.javawithakash.springbootredis.service;

import com.javawithakash.springbootredis.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();

    public Product saveProduct(Product product);

    public Product getProductById(Integer productId);
}
