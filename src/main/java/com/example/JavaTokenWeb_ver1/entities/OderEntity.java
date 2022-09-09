package com.example.JavaTokenWeb_ver1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Oder")
public class OderEntity implements Serializable, Comparable<OderEntity> {
    @Id
    @Column(name = "oderid")
    private Long oderid;

    @Column(name = "createdate")
    private String createdate;

    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "username",referencedColumnName = "username")
    private AccountEntity usernameOder;

    @Override
    public int compareTo(OderEntity o) {
        return (int) (this.oderid-o.getOderid());
    }
}
