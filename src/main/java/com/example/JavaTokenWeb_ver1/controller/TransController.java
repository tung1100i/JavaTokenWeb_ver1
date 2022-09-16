package com.example.JavaTokenWeb_ver1.controller;


import com.example.JavaTokenWeb_ver1.entities.OderDetailEntity;
import com.example.JavaTokenWeb_ver1.services.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/trans")
public class TransController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping("/{username}")
    public List<OderDetailEntity> getTrans(@PathVariable String username){
        return  orderDetailService.findTransByusername(username);
    }
}
