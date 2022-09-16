package com.example.JavaTokenWeb_ver1.services;

import com.example.JavaTokenWeb_ver1.entities.OderDetailEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IOrderDetailService {
        List<OderDetailEntity> findTransByusername(String username);
}
