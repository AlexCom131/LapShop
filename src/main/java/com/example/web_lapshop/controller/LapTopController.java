package com.example.web_lapshop.controller;

import com.example.web_lapshop.entity.LapTopEntity;
import com.example.web_lapshop.service.LapTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class LapTopController {

    @Autowired
    private LapTopService lapTopService;

    @PostMapping("/add")
    public ResponseEntity<LapTopEntity> createLapTop(@RequestBody LapTopEntity laptop) {
        LapTopEntity savedLaptop = lapTopService.saveLapTop(laptop);
        return new ResponseEntity<>(savedLaptop, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LapTopEntity>> getAllLaptops() {
        List<LapTopEntity> laptops = lapTopService.getAllLaptops();
        return ResponseEntity.ok(laptops);
    }


        @GetMapping("/laptop")
        public String showLaptopsPage(Model model) {
        model.addAttribute("laptops", lapTopService.getAllLaptops());
        model.addAttribute("laptop", new LapTopEntity());
        return "laptop";
    }


}
