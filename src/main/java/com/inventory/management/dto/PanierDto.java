package com.inventory.management.dto;

import com.inventory.management.models.Article;
import com.inventory.management.models.Commande;
import com.inventory.management.models.Panier;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PanierDto {
    private Integer id ;
    private Article article;
    private BigDecimal quantity ;
    private BigDecimal prixVente ;
    private Commande commande ;

    public static PanierDto fromEntity(Panier panier){
        return PanierDto.builder()
                .id(panier.getId())
                .article(panier.getArticle())
                .quantity(panier.getQuantity())
                .prixVente(panier.getPrixVente())
                .commande(panier.getCommande())
                .build();
    }

    public static Panier toEntity(PanierDto panier){
        return Panier.builder()
                .id(panier.getId())
                .article(panier.getArticle())
                .quantity(panier.getQuantity())
                .prixVente(panier.getPrixVente())
                .commande(panier.getCommande())
                .build();
    }
}
