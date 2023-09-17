package com.inventory.management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends AbstractEntity{

    private String description ;
    @OneToMany(mappedBy = "category")
    private List<Article> articles ;

}
