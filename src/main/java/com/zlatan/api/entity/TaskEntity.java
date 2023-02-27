package com.zlatan.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "userId")
    private Long userId;
}
