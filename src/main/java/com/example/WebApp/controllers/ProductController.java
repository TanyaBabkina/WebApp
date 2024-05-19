package com.example.WebApp.controllers;
//import com.example.WebApp.models.ChartData;
import com.example.WebApp.models.Product;
import com.example.WebApp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

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
//        model.addAttribute("list_values", ChartData.DataForSummerGraph());
//        model.addAttribute("model_name", ChartData.getListModelsInString());

        List<String> list_of_models = productService.ModelNames();

        String joinedString = String.join(",", list_of_models);
        System.out.println(joinedString);

        String model_names = "Model_1,Model_2,Model_3";

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
//        System.out.println(list_values_mae.stream().mapToInt(List::size).max().getAsInt());

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

        System.out.println(joinedString+"-----------");
        model.addAttribute("model_names", joinedString);
        return "main_page.html";
    }

    @GetMapping("/testModel/{name}")
    public String testModel(@PathVariable String name, Model model) {


        List<String> list_of_metrics = asList("mae_eval", "mae_train", "val_loss", "train_loss");
        List<List<Double>> list_values = new ArrayList<>();
        List<Product> list_model_epochs = productService.EpochsOfModel(name);
        System.out.println(list_model_epochs+name);

        List<Double> tmp_list_mae_eval = new ArrayList<>();
        List<Double> tmp_list_mae_train = new ArrayList<>();
        List<Double> tmp_list_val_loss= new ArrayList<>();
        List<Double> tmp_list_train_loss = new ArrayList<>();

        for (Product listModelEpoch : list_model_epochs) {

            tmp_list_mae_eval.add(listModelEpoch.getMae_eval());
            tmp_list_mae_train.add(listModelEpoch.getMae_train());
            tmp_list_val_loss.add(listModelEpoch.getVal_loss());
            tmp_list_train_loss.add(listModelEpoch.getTrain_loss());
        }
        list_values.add(tmp_list_mae_eval);
        list_values.add(tmp_list_mae_train);
        list_values.add(tmp_list_val_loss);
        list_values.add(tmp_list_train_loss);


        System.out.println(list_values);
        String joinedString = String.join(",", list_of_metrics);
        System.out.println(joinedString);
        System.out.println(name+"------------");


        model.addAttribute("list_values", list_values);
        model.addAttribute("model_name", joinedString);
        model.addAttribute("name", name);

        return "testModel.html";
    }




}
