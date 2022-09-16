package com.example.JavaTokenWeb_ver1.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
public class ProductEntity implements Comparable<ProductEntity> {
    @Id
    @Column(name = "productid", insertable = false, updatable = false)
    private Long productid;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "categoryid",referencedColumnName = "categoryid")
    private CategoryEntity categoryid;


    //    @OneToMany(mappedBy ="product_id")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<Product_OrderDetailEntity> product_orderDetailEntities;


    @Override
    public int compareTo(ProductEntity o) {
        return (int) (this.productid - o.getProductid());
    }

}
