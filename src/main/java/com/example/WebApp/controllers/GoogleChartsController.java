package com.example.WebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GoogleChartsController {

    @GetMapping("/chart")
    public String showLineChart(Model model) {
//        List<String> model_names = Arrays.asList("Model_1", "Model_2", "Model_3");
//        List<Integer> yValues = Arrays.asList(10, 20, 15, 25, 30);
//        System.out.println(xValues);
//        model.addAttribute("xValues", xValues);
//        model.addAttribute("yValues", yValues);
        String model_names = "Model_1,Model_2,Model_3";
        // Создаем двумерный список
        List<List<Integer>> list_values = new ArrayList<>();

        // Добавляем первый внутренний список
        List<Integer> innerList1 = new ArrayList<>();
        innerList1.add(1);
        innerList1.add(2);
        innerList1.add(3);
        list_values.add(innerList1);

        // Добавляем второй внутренний список
        List<Integer> innerList2 = new ArrayList<>();
        innerList2.add(4);
        innerList2.add(5);
        innerList2.add(6);
        list_values.add(innerList2);

        // Добавляем третий внутренний список
        List<Integer> innerList3 = new ArrayList<>();
        innerList3.add(7);
        innerList3.add(8);
        innerList3.add(9);
        list_values.add(innerList3);
        model.addAttribute("list_values", list_values);
        model.addAttribute("model_name", model_names);
        return "google-charts";
    }
}
