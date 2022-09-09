package com.example.JavaTokenWeb_ver1.repositories;



import com.example.JavaTokenWeb_ver1.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<ProductEntity,Long> {
}
