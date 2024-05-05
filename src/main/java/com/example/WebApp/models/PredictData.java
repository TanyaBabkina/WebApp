package com.example.WebApp.models;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PredictData {
    private String date;
    private double t_air;
    private double atm_dav;
    private double wind;
    private double snow_level;
    private double rain;
    private String model_name;

}
