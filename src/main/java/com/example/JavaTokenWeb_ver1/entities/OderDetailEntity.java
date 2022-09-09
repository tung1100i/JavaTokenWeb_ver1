package com.example.JavaTokenWeb_ver1.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Oder_Detail")

public class OderDetailEntity implements Serializable, Comparable<OderDetailEntity> {
    @Id
    @Column(name = "detailid")
    private Long detailid;

    private Long orderid;

    @ManyToOne
    @JoinColumn(name = "productid",referencedColumnName = "productid")
    private ProductEntity productid;

    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;


    @Override
    public int compareTo(OderDetailEntity o) {
        return (int) (this.detailid-o.getDetailid());
    }
}
