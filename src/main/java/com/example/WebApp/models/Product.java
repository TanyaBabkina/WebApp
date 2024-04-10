package com.example.WebApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "graph")
@Data
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long ID;
    @Column(name = "x")
    private double x;
    @Column(name = "y")
    private double y;

    @Column(name = "title")
    private String title;


    public Product() {
    }
}
