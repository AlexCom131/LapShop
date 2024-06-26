package com.example.web_lapshop.controller;

import com.example.web_lapshop.entity.UserEntity;
import com.example.web_lapshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    // Обробка реєстрації користувача
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserEntity newUser, Model model) {
        try {
            userService.registerUser(newUser);
            model.addAttribute("successMessage", "Користувач успішно зареєстрований!");
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        if (model.containsAttribute("errorMessage")) {
            model.addAttribute("errorMessage", model.getAttribute("errorMessage"));
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        if (userService.checkUser(username, password)) {
            UserEntity user = userService.findByUsername(username);
            session.setAttribute("userId", user.getId());
            return "redirect:/index";
        } else {
            model.addAttribute("errorMessage", "Неправильний логін або пароль.");
            return "login";
        }
    }
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "user";
//    }
//
//    @PostMapping("/login")
//    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
//        boolean isValidUser = userService.checkUser(username, password);
//
//        if (isValidUser) {
//            return "redirect:/main"; // Перенаправляємо на головну сторінку після успішного входу
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login"; // Повертаємо знову на сторінку логіну з помилкою
//        }
//    }

}
