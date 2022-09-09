package com.example.JavaTokenWeb_ver1.services;

import com.example.JavaTokenWeb_ver1.entities.CategoryEntity;


import java.util.List;
import java.util.Optional;

public interface ICategoryService {


    //FIND ALL CATEGORY
    List<CategoryEntity> findAll();

    //ADD NEW CATEGORY
    CategoryEntity addCategory(CategoryEntity category);

    //FIND CATEGORY BY NAME
    Optional<CategoryEntity> findCategoryname(String categoryname);
    //FIND CATEGORY BY ID
    Optional<CategoryEntity> findCategoryId(String categoryname);

    //UPDATE
    CategoryEntity updateCateID(CategoryEntity category);


}
