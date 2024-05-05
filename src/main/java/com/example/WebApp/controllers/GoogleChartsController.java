package com.example.WebApp.controllers;

import java.util.Map;
import java.util.TreeMap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//@Controller
//@RequiredArgsConstructor
//public class GoogleChartsController {
//    @GetMapping("/chart")
//    public String getPieChart(Model model) {
//        Map<String, Integer> graphData = new TreeMap<>();
//        graphData.put("Epoch 1", 147);
//        graphData.put("Epoch 2", 1256);
//        graphData.put("Epoch 3", 3856);
//        graphData.put("Epoch 4", 19807);
//        model.addAttribute("chartData", graphData);
//        return "google-charts.html";
//    }
//}
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// В вашем контроллере
@Controller
@RequiredArgsConstructor
public class GoogleChartsController {
    @GetMapping("/chart")
    public String getPieChart(Model model) throws JsonProcessingException {
        Map<Integer, Integer> graphData = new TreeMap<>();
        graphData.put(1, 147);
        graphData.put(2, 1256);
        graphData.put(3, 3856);
        graphData.put(4, 19807);

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(graphData);

        model.addAttribute("chartData", jsonData);
        return "google-charts.html";
    }
}