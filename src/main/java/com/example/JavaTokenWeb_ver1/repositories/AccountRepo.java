package com.example.JavaTokenWeb_ver1.repositories;


import com.example.JavaTokenWeb_ver1.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, String> {

    @Query(value = "SELECT * FROM Account WHERE LOWER(fullname) LIKE %?1%", nativeQuery = true)
    Optional<AccountEntity> findByName(String fullname);


    AccountEntity findByUsername(String username);


}
