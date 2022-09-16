package com.example.JavaTokenWeb_ver1.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class CourseRatingKey implements Serializable {

    @Column(name = "orderdetailid")
    Long orderdetailid;

    @Column(name = "productid")
    Long productid;

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}
