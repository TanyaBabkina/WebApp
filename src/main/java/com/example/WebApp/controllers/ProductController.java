package com.example.WebApp.controllers;

import com.example.WebApp.models.Product;
import com.example.WebApp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
// эту часть можно убрать, так как есть декоратор RequiredArgsConstructor
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/")
    // Возвращает название html файла
    // model - передаёт данные в html
    public String products(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("products", productService.ModelNames());
        return "products";
    }

    @GetMapping("/testModel/{name}")
    public String testModel(@PathVariable String name, Model model) {
        model.addAttribute("products", productService.EpochsOfModel(name));
        return "testModel";
    }


}
