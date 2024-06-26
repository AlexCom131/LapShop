package com.example.web_lapshop.controller;

import com.example.web_lapshop.entity.LapTopEntity;
import com.example.web_lapshop.entity.UserEntity;
import com.example.web_lapshop.service.LapTopService;
import com.example.web_lapshop.service.PurchaseService;
import com.example.web_lapshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/buy")
    public String buyLaptop(@RequestParam Long userId, @RequestParam Long laptopId, Model model) {
        try {
            purchaseService.makePurchase(userId, laptopId);
            model.addAttribute("successMessage", "Покупка успішна!");
            return "redirect:/index";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error"; // створіть відповідну сторінку для відображення помилок

        }

    }

//    @PostMapping("/buy")
//    public String buyLaptop(@RequestParam Long laptopId, HttpSession session, Model model) {
//        Long userId = (Long) session.getAttribute("userId");
//        if (userId == null) {
//            return "redirect:/login";
//        }
//
//        try {
//            // Отримати користувача за userId
//            UserEntity user = UserService.findById(userId);
//
//            // Отримати ноутбук за laptopId
//            LapTopEntity laptop = LapTopService.findById(laptopId);
//
//            // Перевірити, чи існують користувач і ноутбук
//            if (user == null) {
//                throw new RuntimeException("Користувач не знайдений");
//            }
//            if (laptop == null) {
//                throw new RuntimeException("Ноутбук не знайдений");
//            }
//
//            // Здійснити покупку
//            purchaseService.makePurchase(user, laptop);
//
//            // Додати повідомлення про успішну покупку до моделі
//            model.addAttribute("successMessage", "Покупка успішна!");
//
//            // Перенаправити на головну сторінку
//            return "redirect:/index";
//        } catch (Exception e) {
//            // В разі виникнення помилки додати повідомлення про помилку до моделі
//            model.addAttribute("errorMessage", e.getMessage());
//            return "error"; // або повернути на сторінку з помилкою
//        }
//    }
}