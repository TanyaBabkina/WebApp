package com.example.WebApp.repositories;

import com.example.WebApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    void findByTitle(String title);
    List<Product> findByTitle(String title);
}
