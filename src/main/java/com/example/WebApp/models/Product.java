package com.example.WebApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "model_data")
@Data
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "train_loss")
    private double train_loss;
    @Column(name = "val_loss")
    private double val_loss;
    @Column(name = "mae_train")
    private double mae_train;
    @Column(name = "mae_eval")
    private double mae_eval;
    @Column(name = "epoch")
    private int epoch;
    @Column(name = "name")
    private String name;



    public Product() {
    }
}
