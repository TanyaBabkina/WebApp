package com.example.WebApp.controllers;

import com.example.WebApp.models.DataLearnModel;
import com.example.WebApp.models.PredictData;
import com.example.WebApp.models.Product;
import com.example.WebApp.models.TestResult;
import com.example.WebApp.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

@Controller
@RequiredArgsConstructor
public class RestApiController {
    private final ProductService productService;



    // получение данных по апи и запись в бд
    @PostMapping("/api/getData")
    public String getModelData(@RequestParam double train_loss, double val_loss, double mae_eval, double mae_train, int epoch, String name){
        String jsonData = null;
        try{
            jsonData = train_loss+" "+val_loss+" "+mae_train+" "+mae_eval+" "+epoch+" "+name;


            Product product = new Product();
            product.setTrain_loss(train_loss);
            product.setVal_loss(val_loss);
            product.setMae_train(mae_train);
            product.setMae_eval(mae_eval);
            product.setEpoch(epoch);
            product.setName(name);
            productService.saveProduct(product);
            System.out.println(jsonData);

        }catch (Exception e){
            System.out.println("Error: "+e);
//            System.out.println(product.getX()+"-"+product.getY()+"-"+product.getTitle());
        }
        return jsonData;
    }
    //    @RequestParam(name = "name", required = false) String name, Model model

    // отправка данных для получения прредсказания
    @PostMapping("/api/sendData")
    public static String SendData(@ModelAttribute String model_name,
                                  String date, double t_air, double atm_dav,
                                  double wind, double snow_level, double rain, Model model ) throws IOException, URISyntaxException {
        System.out.println(model_name);
        PredictData predict_data = new PredictData();
        predict_data.setModel_name(model_name);
        predict_data.setDate(date);
        predict_data.setT_air(t_air);
        predict_data.setAtm_dav(atm_dav);
        predict_data.setWind(wind);
        predict_data.setSnow_level(snow_level);
        predict_data.setRain(rain);



        // преобразование в json
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(predict_data);

        URL url = new URL("http://localhost:8000/info").toURI().toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        // Send request to an API
        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
            dos.writeBytes(requestBody);
        }
        double rez = 0.0;
        System.out.println("Response code: " + conn.getResponseCode());




//        // Read Response from and API
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;

            while ((line = bf.readLine()) != null) {
                System.out.println(line);
                ObjectMapper mapper = new ObjectMapper();
                TestResult resp = objectMapper.readValue(line, TestResult.class);
                rez = resp.getWaterLevel();
            }
        }


        model.addAttribute("rez", rez);
        return "predict_rez";
    }

    // отправка данных для обучения новой модели
    @PostMapping("/api/sendLearningData")
    public static String SendData1(@ModelAttribute String model_name,
                                  int post_code, double alpha, int batch,
                                  int num_epochs, int hidden_size, Model model ) throws IOException, URISyntaxException {
//        System.out.println(alpha + " fgvgbnhm,.");
        DataLearnModel learn_data = new DataLearnModel();
        learn_data.setModel_name(model_name);
        learn_data.setPost_code(post_code);
        learn_data.setAlpha(alpha);
        learn_data.setBatch(batch);
        learn_data.setNum_epochs(num_epochs);
        learn_data.setHidden_size(hidden_size);


        System.out.println("cqadeqec");
        // преобразование в json
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(learn_data);
        ///////////////////////////////////////////////////////////////////////
        URL url = new URL("http://localhost:8000/learn").toURI().toURL();
        ///////////////////////////////////////////////////////////////////////
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        // Send request to an API
        try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
            dos.writeBytes(requestBody);
        }
        double rez = 0.0;
        System.out.println("Response code: " + conn.getResponseCode());




//        // Read Response from and API
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;

            while ((line = bf.readLine()) != null) {
                System.out.println(line);
                ObjectMapper mapper = new ObjectMapper();
                TestResult resp = objectMapper.readValue(line, TestResult.class);
                rez = resp.getWaterLevel();
            }
        }


        model.addAttribute("rez", rez);
        return "redirect:/";
    }
}
