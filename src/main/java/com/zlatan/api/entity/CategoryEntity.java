package com.zlatan.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String url;
    private String icon;
    private boolean highlight;
}
