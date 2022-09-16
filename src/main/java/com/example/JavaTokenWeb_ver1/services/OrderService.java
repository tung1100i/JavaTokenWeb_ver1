package com.example.JavaTokenWeb_ver1.services;


import com.example.JavaTokenWeb_ver1.entities.OderEntity;
import com.example.JavaTokenWeb_ver1.repositories.OderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OderRepo oderRepo;

    @Override
    public List<OderEntity> findOderByusername(String username) {
        return oderRepo.getOder(username);
    }
}
