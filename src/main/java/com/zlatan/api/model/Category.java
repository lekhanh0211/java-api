package com.zlatan.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private long id;
    private String name;
    private String url;
    private String icon;
    private boolean highlight;

}
