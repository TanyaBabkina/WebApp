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
    public String products(@RequestParam(name = "title", required = false) String title, Model model){
        model.addAttribute("products", productService.listProduct(title));
        return "products";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/testModel/{ID}")
    public String testModel(@PathVariable Long ID, Model model) {
        model.addAttribute("products", productService.getProductById(ID));
        return "testModel";
    }


}
