package com.example.JavaTokenWeb_ver1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home(){
//        return ("<h1>hellospring</h1>");
        return "hellospring";
    }

}
