package com.inventory.management.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Article extends AbstractEntity{

    private String reference ;
    private String designation ;
    @Column(name = "quantité_stock")
    private Integer stockQuantity ;
    @Column(name = "prix")
    private BigDecimal price ;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category ;
}
