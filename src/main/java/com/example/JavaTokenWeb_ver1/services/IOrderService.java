package com.example.JavaTokenWeb_ver1.services;


import com.example.JavaTokenWeb_ver1.entities.OderEntity;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    List<OderEntity> findOderByusername(String username);
}
