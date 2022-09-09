package com.example.JavaTokenWeb_ver1.repositories;


import com.example.JavaTokenWeb_ver1.entities.OderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OderDetailRepo extends JpaRepository<OderEntity,Long> {
}
