package com.example.WebApp.controllers;

import com.example.WebApp.models.Product;
import com.example.WebApp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GoogleChartsController {
    private final ProductService productService;
    @GetMapping("/chart")
    public String showLineChart(Model model) {

        List<String> list_of_models = productService.ModelNames();

        String joinedString = String.join(",", list_of_models);
        System.out.println(joinedString);



        List<List<Double>> list_values_mae = new ArrayList<>();
        for (String listOfModel : list_of_models) {
            System.out.println(listOfModel);
            List<Product> model_metrics = productService.EpochsOfModel(listOfModel);
            List<Double> mae_list = new ArrayList<>();
            for (Product modelMetric : model_metrics) {
                double mae = modelMetric.getMae_eval();
                mae_list.add(mae);
            }
            list_values_mae.add(mae_list);
        }
        System.out.println(list_values_mae);
        int max_inner_list = list_values_mae.stream().mapToInt(List::size).max().getAsInt();


        // Сравнять количество элементов в списках
        for (List<Double> doubles : list_values_mae) {
            if (doubles.size() < max_inner_list) {
                while (doubles.size() != max_inner_list) {
                    doubles.add(null);
                }
            }
        }
        System.out.println(list_values_mae);

        model.addAttribute("list_values", list_values_mae);
        model.addAttribute("model_name", joinedString);
        return "google-charts";
    }
}
