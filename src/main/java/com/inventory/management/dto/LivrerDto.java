package com.inventory.management.dto;

import com.inventory.management.models.Approvisionnement;
import com.inventory.management.models.Article;
import com.inventory.management.models.Livrer;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LivrerDto {
    private Integer id ;
    private Article article ;
    private Integer quantity ;
    private Float prixAchat ;
    private Approvisionnement approvisionnement ;

    public static LivrerDto fromEntity(Livrer livrer){
        return LivrerDto.builder()
                .id(livrer.getId())
                .article(livrer.getArticle())
                .quantity(livrer.getQuantity())
                .prixAchat(livrer.getPrixAchat())
                .approvisionnement(livrer.getApprovisionnement())
                .build() ;
    }

    public static Livrer toEntity(LivrerDto livrer){
        return Livrer.builder()
                .id(livrer.getId())
                .article(livrer.getArticle())
                .quantity(livrer.getQuantity())
                .prixAchat(livrer.getPrixAchat())
                .approvisionnement(livrer.getApprovisionnement())
                .build() ;
    }
}
