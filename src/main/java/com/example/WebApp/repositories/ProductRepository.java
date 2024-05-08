package com.example.WebApp.repositories;

import com.example.WebApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
//    void findByTitle(String title);
    void findByName(String name);
    @Query("SELECT DISTINCT m.name FROM Product m")
    List<String> findDistinctName();

    @Query("select m from Product m where m.name = ?1")
    List<Product> findAllByName(String name);
}
