package com.vikasproject.springcrud.service;

import com.vikasproject.springcrud.entity.Product;
import com.vikasproject.springcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> saveProducts(List<Product> product){
        return productRepository.saveAll(product);
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }
    public String deleteProductById(int id){
        productRepository.deleteById(id);
        return "product remove ||"+id;
    }
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }
}
