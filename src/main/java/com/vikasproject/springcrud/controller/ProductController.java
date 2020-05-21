package com.vikasproject.springcrud.controller;

import com.vikasproject.springcrud.entity.Product;
import com.vikasproject.springcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public Product getProductById(@PathVariable  String name){
        return productService.getProductByName(name);
    }
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public String updateProduct(@PathVariable int id) {
        return productService.deleteProductById(id);
    }
}
