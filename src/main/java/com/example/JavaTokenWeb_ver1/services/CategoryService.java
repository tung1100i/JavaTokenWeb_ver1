package com.example.JavaTokenWeb_ver1.services;


import com.example.JavaTokenWeb_ver1.entities.CategoryEntity;
import com.example.JavaTokenWeb_ver1.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public CategoryEntity addCategory(CategoryEntity category) {
        return categoryRepo.save(category);
    }

    @Override
    public Optional<CategoryEntity> findCategoryname(String categoryname) {
        return categoryRepo.findByName(categoryname);
    }

    @Override
    public Optional<CategoryEntity> findCategoryId(String categoryname) {
        return categoryRepo.findById(categoryname);
    }

    @Override
    public CategoryEntity updateCateID(CategoryEntity newcateid) {
        CategoryEntity categoryUpdate = new CategoryEntity();
        categoryUpdate.setCategoryid(newcateid.getCategoryid());
        categoryUpdate.setName(newcateid.getName());
        return categoryRepo.save(categoryUpdate);
    }

}
