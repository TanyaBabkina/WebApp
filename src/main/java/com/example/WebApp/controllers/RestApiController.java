package com.example.WebApp.controllers;

import com.example.WebApp.models.Product;
import com.example.WebApp.services.ProductService;
import com.fasterxml.jackson.core.JacksonException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestApiController {
    private final ProductService productService;

    @GetMapping("/api/main")
    public String mainListener(){
        return "Hello world!";
    }
    @PostMapping("/api/getData")
    public String getModelData(@RequestParam double metric1, double metric2, int epoch, String name){
        String jsonData = null;
        try{
            jsonData = metric1+" "+metric2+" "+epoch+" "+name;


            Product product = new Product();
            product.setTitle(name);
            product.setX(metric1);
            product.setY(metric2);
            System.out.println(product.getX()+"-"+product.getY()+"-"+product.getTitle());
            productService.saveProduct(product);
            System.out.println(jsonData);

        }catch (Exception e){
            System.out.println("Error: "+e);
//            System.out.println(product.getX()+"-"+product.getY()+"-"+product.getTitle());
        }
        return jsonData;
    }
}
