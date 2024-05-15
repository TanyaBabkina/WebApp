package com.example.WebApp.models;

import lombok.Data;

@Data
public class DataLearnModel {
    private String model_name;
    private int post_code;
    private double alpha;
    private int batch;
    private int num_epochs;
    private int hidden_size;
}
