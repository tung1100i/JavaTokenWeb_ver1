package com.example.JavaTokenWeb_ver1.controller;


import com.example.JavaTokenWeb_ver1.entities.CategoryEntity;
import com.example.JavaTokenWeb_ver1.services.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/")
    public List<CategoryEntity> findAll() {
        return iCategoryService.findAll();
    }

    @PostMapping("/add")
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return iCategoryService.addCategory(category);
    }

    @GetMapping("/search-name/{categoryname}")
    public Optional<CategoryEntity> findByCateName(@PathVariable String categoryname) {
        return iCategoryService.findCategoryname(categoryname);
    }

    @GetMapping("/search-id/{categoryid}")
    public Optional<CategoryEntity> findByCateID(@PathVariable String categoryid) {
        return iCategoryService.findCategoryId(categoryid);
    }

    //EDIT BY CATEGORY ID
    @PutMapping("edit/{cateid}")
    public CategoryEntity updateCateID(@RequestBody CategoryEntity updateCateById, @PathVariable String cateid) {
        return iCategoryService.updateCateID(updateCateById);
    }
}
