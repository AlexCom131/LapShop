package com.example.web_lapshop.controller;

import com.example.web_lapshop.service.LapTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PolicyController {

    @Autowired
    private LapTopService lapTopService;


}
