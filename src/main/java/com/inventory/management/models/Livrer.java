package com.inventory.management.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Livrer extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article ;
    @Column(name = "qte_livrée")
    private Integer quantity ;
    @Column(name = "prix_achat")
    private Float prixAchat ;
    @ManyToOne
    @JoinColumn(name = "id_approv")
    private Approvisionnement approvisionnement ;



}
