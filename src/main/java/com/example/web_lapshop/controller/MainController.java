package com.example.web_lapshop.controller;

import com.example.web_lapshop.entity.LapTopEntity;
import com.example.web_lapshop.service.LapTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
//@RequestMapping("/main")
public class MainController {
    @Autowired
    private LapTopService lapTopService;

    @GetMapping("/index")
    public String showLaptopsPage(Model model) {

        List<Long> actionProductIds = Arrays.asList(2L, 4L, 6L, 3L);
        List<Long> popularProductIds = Arrays.asList(1L, 2L, 4L, 6L);
        List<Long> recommendProductIds = Arrays.asList(2L, 5L, 4L, 6L);


        List<LapTopEntity> actionProductLaptops = lapTopService.findLaptopsByIds(actionProductIds);
        List<LapTopEntity> popularProductLaptops = lapTopService.findLaptopsByIds(popularProductIds);
        List<LapTopEntity> recommendProductLaptops = lapTopService.findLaptopsByIds(recommendProductIds);

        model.addAttribute("actionProductLaptops", actionProductLaptops);
        model.addAttribute("popularProductLaptops", popularProductLaptops);
        model.addAttribute("recommendProductLaptops", recommendProductLaptops);

        return "index";
    }

    @GetMapping("/policy")
    public String policy() {
        return "policy";
    }
}
