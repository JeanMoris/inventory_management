package com.inventory.management.dto;

import com.inventory.management.models.Approvisionnement;
import com.inventory.management.models.Fournisseur;
import com.inventory.management.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApprovisionnementDto {
    private Integer id ;
    private String reference ;
    private LocalDateTime dateLivraison ;
    private BigDecimal montantFacture ;
    private Fournisseur fournisseur ;
    private User user ;

    public static ApprovisionnementDto fromEntity(Approvisionnement approvisionnement){
        return ApprovisionnementDto.builder()
                .id(approvisionnement.getId())
                .reference(approvisionnement.getReference())
                .dateLivraison(approvisionnement.getDateLivraison())
                .montantFacture(approvisionnement.getMontantFacture())
                .fournisseur(approvisionnement.getFournisseur())
                .user(approvisionnement.getUser())
                .build() ;
    }

    public static Approvisionnement toEntity(ApprovisionnementDto approvisionnement){
        return Approvisionnement.builder()
                .id(approvisionnement.getId())
                .reference(approvisionnement.getReference())
                .dateLivraison(approvisionnement.getDateLivraison())
                .montantFacture(approvisionnement.getMontantFacture())
                .fournisseur(approvisionnement.getFournisseur())
                .user(approvisionnement.getUser())
                .build() ;
    }
}
