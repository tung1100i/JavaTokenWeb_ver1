package com.example.JavaTokenWeb_ver1.services;

import com.example.JavaTokenWeb_ver1.entities.OderDetailEntity;
import com.example.JavaTokenWeb_ver1.repositories.OderDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService{

    @Autowired
    OderDetailRepo oderDetailRepo;
    @Override
    public List<OderDetailEntity> findTransByusername(String username) {
        return oderDetailRepo.findTrans(username);
    }
}
