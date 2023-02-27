package com.zlatan.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private double price;
    private String desc;
    private String specification;
    private boolean highlight;
    private boolean status;


}
