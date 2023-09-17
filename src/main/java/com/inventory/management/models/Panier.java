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
public class Panier extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;
    @Column(name = "qte_Vente")
    private BigDecimal quantity ;
    @Column(name = "prix_vente")
    private BigDecimal prixVente ;
    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Commande commande ;
}
