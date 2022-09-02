package com.parcel.delivery.model;

import javax.persistence.*;

@Entity
public class TestClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Transient
    private String age;

    private String xys;
}
