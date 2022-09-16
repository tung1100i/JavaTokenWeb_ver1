package com.example.JavaTokenWeb_ver1.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Category")
public class CategoryEntity  implements Comparable<CategoryEntity> {
    @Id
    @Column(name = "categoryid")
    private String categoryid;

    @Column(name = "category_name")
    private String category_name;

    @OneToMany(mappedBy = "categoryid", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Collection<ProductEntity> productEntities;
    @Override
    public int compareTo(CategoryEntity o) {
        return  (this.categoryid.compareTo(o.getCategoryid()));
    }
}
