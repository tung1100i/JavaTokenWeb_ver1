package com.example.JavaTokenWeb_ver1.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Oder_Detail")

public class OderDetailEntity implements  Comparable<OderDetailEntity> {
    @Id
    @Column(name = "detailid")
    private Long detailid;

//    @ManyToOne
//    @JoinColumn(name = "oderDetailEntity") // thông qua khóa ngoại username
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private OderEntity orderid;

    private Long orderid;

//    @OneToMany(mappedBy ="oderDetail_id", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<Product_OrderDetailEntity> product_orderDetailEntities;

    @OneToMany(mappedBy = "productid", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private List<ProductEntity> productList;


    @Column(name = "oder_detail_price")
    private double oder_detail_price;

    @Column(name = "quantity_order_detail")
    private int quantity_order_detail;


    @Override
    public int compareTo(OderDetailEntity o) {
        return (int) (this.detailid-o.getDetailid());
    }
}
