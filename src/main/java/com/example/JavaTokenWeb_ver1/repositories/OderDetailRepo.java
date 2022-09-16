package com.example.JavaTokenWeb_ver1.repositories;


import com.example.JavaTokenWeb_ver1.entities.OderDetailEntity;
import com.example.JavaTokenWeb_ver1.entities.OderEntity;
import org.hibernate.tool.schema.ast.SqlScriptParserException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OderDetailRepo extends JpaRepository<OderDetailEntity, Long> {

    @Query(value = "SELECT  * FROM VIEWALL", nativeQuery = true)
    List<OderDetailEntity> findTrans(String username) throws SqlScriptParserException;
}
