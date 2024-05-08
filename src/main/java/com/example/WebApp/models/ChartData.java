//package com.example.WebApp.models;
//
//import com.example.WebApp.services.ProductService;
//import lombok.Data;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Data
//@RequiredArgsConstructor
//public class ChartData {
//
////    public static Object listModelsInString;
//    private final ProductService productService;
//    private List<String> list_of_models = productService.ModelNames();
//    private String listModelsInString =  String.join(",", list_of_models);
//
//    public static List<List<Double>> DataForSummerGraph(){
//
//        List<List<Double>> list_values_mae = new ArrayList<>();
//        String listModelsInString = String.join(",", list_of_models);
//        for (String listOfModel : list_of_models) {
//            System.out.println(listOfModel);
//            List<Product> model_metrics = productService.EpochsOfModel(listOfModel);
//            List<Double> mae_list = new ArrayList<>();
//            for (Product modelMetric : model_metrics) {
//                double mae = modelMetric.getMae_eval();
//                mae_list.add(mae);
//            }
//            list_values_mae.add(mae_list);
//        }
//        System.out.println(list_values_mae);
//        int max_inner_list = list_values_mae.stream().mapToInt(List::size).max().getAsInt();
////        System.out.println(list_values_mae.stream().mapToInt(List::size).max().getAsInt());
//
//        // Сравнять количество элементов в списках
//        for (List<Double> doubles : list_values_mae) {
//            if (doubles.size() < max_inner_list) {
//                while (doubles.size() != max_inner_list) {
//                    doubles.add(null);
//                }
//            }
//        }
//    return list_values_mae;
//    }
//
//
//}
