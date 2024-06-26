package com.example.web_lapshop.controller;

import ch.qos.logback.core.model.Model;
import com.example.web_lapshop.entity.UserEntity;
import com.example.web_lapshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("/api/auth")
public class UserController{

    @Autowired
    private UserService userService;

//    @PostMapping("/")
//    public ResponseEntity registration(@RequestBody UserEntity user){
//
//        try{
//
//            userService.registration(user);
//            return ResponseEntity.ok("Реєстрація пройшла успішно");
//        } catch (UserAlreadyExistExeption e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//        catch (Exception e){
//            return ResponseEntity.badRequest().body("От халепа");
//        }
//    }



//    @GetMapping
//    public ResponseEntity getOneUser(@RequestParam String username ){
//
//        try{
//            return ResponseEntity.ok(userService.getOne(username));
//        }
//        catch (UserNotFoundExistExeption e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//        catch (Exception e){
//            return ResponseEntity.badRequest().body("От халепа");
//        }
//    }

}