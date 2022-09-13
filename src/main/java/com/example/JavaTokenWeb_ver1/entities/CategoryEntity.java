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
@Table(name = "Category")
public class CategoryEntity  implements Comparable<CategoryEntity> {
    @Id
    @Column(name = "categoryid")
    private String categoryid;

    private String name;

    @Override
    public int compareTo(CategoryEntity o) {
        return  (this.categoryid.compareTo(o.getCategoryid()));
    }
}
