package com.example.JavaTokenWeb_ver1.repositories;


import com.example.JavaTokenWeb_ver1.entities.AccountEntity;
import org.hibernate.tool.schema.ast.SqlScriptParserException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, String> {

    @Query(value = "SELECT * FROM Account WHERE LOWER(fullname) LIKE %?1%", nativeQuery = true)
    Optional<AccountEntity> findByName(String fullname);

//    @Query(value = "SELECT Account.username," +
//            "Oder.oderid, Oder.createdate," +
//            "Oder_Detail.detailid,Oder_Detail.oder_detail_price,Oder_Detail.quantity_order_detail,Oder_Detail.productid," +
//            "Product.product_name, Product.price, Product.quantity, Category.categoryid, Category.category_name " +
//            "from Account " +
//            "JOIN Oder ON account.username = Oder.username " +
//            "RIGHT JOIN Oder_Detail ON Oder.oderid = Oder_Detail.orderid " +
//            "LEFT JOIN Product ON Oder_Detail.productid = Product.productid " +
//            "RIGHT JOIN Category ON Product.categoryid= Category.categoryid " +
//            "Where ACCOUNT.username like %?1% " +
//            "ORDER BY Oder.oderid ASC", nativeQuery = true)
//    @Query(value = "SELECT AccountEntity.username," +
//            "OderEntity.oderid, OderEntity.createdate," +
//            "OderDetailEntity.detailid,OderDetailEntity.price,OderDetailEntity.quantity_order_detail,OderDetailEntity.productid," +
//            "ProductEntity .product_name, ProductEntity .price, ProductEntity .quantity, CategoryEntity .categoryid, CategoryEntity .category_name " +
//            "from AccountEntity " +
//            "JOIN OderDetailEntity ON AccountEntity.username = OderEntity.usernameOder" +
//            "RIGHT JOIN OderDetailEntity ON OderEntity .oderid = OderDetailEntity.orderid " +
//            "RIGHT JOIN ProductEntity ON OderDetailEntity.productid = ProductEntity.productid " +
//            "RIGHT JOIN CategoryEntity ON ProductEntity.categoryid= ProductEntity.categoryid " +
//            "Where AccountEntity.username like %?1% " +
//            "ORDER BY OderEntity .oderid ASC")
//    @Query(value = "SELECT  * FROM VIEWALL",nativeQuery = true)
//    String findTrans(String username) throws SqlScriptParserException;

    AccountEntity findByUsername(String username);


}
