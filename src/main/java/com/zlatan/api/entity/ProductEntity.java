package com.zlatan.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private String desc;
    private String specification;
    private boolean highlight;
    private boolean status;
    @Column(name = "catId")
    private long catId;
}
