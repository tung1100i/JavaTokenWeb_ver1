package com.example.JavaTokenWeb_ver1.controller;


import com.example.JavaTokenWeb_ver1.entities.OderEntity;
import com.example.JavaTokenWeb_ver1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oder")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOder/{username}")
    public List<OderEntity> getOderByUsername(@PathVariable String username){
        return orderService.findOderByusername(username);
    }
}
