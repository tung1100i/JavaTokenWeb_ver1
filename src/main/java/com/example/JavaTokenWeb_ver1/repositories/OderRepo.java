package com.example.JavaTokenWeb_ver1.repositories;



import com.example.JavaTokenWeb_ver1.entities.OderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OderRepo extends JpaRepository<OderEntity,Long> {

//    @Query(value = "SELECT o FROM OderEntity o WHERE o.usernameOder like %?1%")
    @Query(value = "SELECT * FROM Oder o WHERE o.username like %?1%",nativeQuery = true)
    List<OderEntity> getOder(String username);
}
