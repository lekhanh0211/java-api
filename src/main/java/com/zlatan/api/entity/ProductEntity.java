package com.zlatan.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private long catId;
    private double price;
    private String desc;
    private String specification;
    private boolean highlight;
    private boolean status;
}
