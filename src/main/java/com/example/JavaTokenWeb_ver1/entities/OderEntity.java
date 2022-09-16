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
@Table(name = "Oder")
public class OderEntity implements Comparable<OderEntity> {
    @Id
    @Column(name = "oderid")
    private Long oderid;

    @Column(name = "createdate")
    private String createdate;

//    @ManyToOne
//    @JoinColumn(name = "username") // thông qua khóa ngoại username
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @Column(name = "username")
//    private AccountEntity usernameOder;

    @Column(name = "username")
    private String usernameOder;

    @Column(name = "total")
    private float total;

    @OneToMany(mappedBy = "orderid", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private List<OderDetailEntity> oderDetailEntity;


    @Override
    public int compareTo(OderEntity o) {
        return (int) (this.oderid - o.getOderid());
    }
}
