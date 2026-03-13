package com.javawithakash.springbootredis.controller;

import com.javawithakash.springbootredis.entity.Product;
import com.javawithakash.springbootredis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getAllProduct (){
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

   @PostMapping(("/saveProduct"))
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
       Product savedProduct = productService.saveProduct(product);
       return new ResponseEntity<>(savedProduct, HttpStatus.OK);
   }

   @GetMapping("/byId")
    public ResponseEntity<Product> getByproductId(@RequestParam Integer id){
       Product productById = productService.getProductById(id);
       return new ResponseEntity<>(productById, HttpStatus.OK);
   }
}
