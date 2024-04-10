package com.example.WebApp.services;

import com.example.WebApp.models.Product;
import com.example.WebApp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<Product> listProduct(String title){
        if (title != null) productRepository.findByTitle(title);

        return productRepository.findAll();
    }
    public void saveProduct(Product product){
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public void deleteProduct(long ID){
        productRepository.deleteById(ID);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }


}
