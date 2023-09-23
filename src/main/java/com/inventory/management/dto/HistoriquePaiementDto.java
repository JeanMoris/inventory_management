package com.inventory.management.dto;

import com.inventory.management.models.Commande;
import com.inventory.management.models.HistoriquePaiement;
import com.inventory.management.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class HistoriquePaiementDto {

    private Integer id ;
    private LocalDateTime datePaiement ;
    private Commande commande ;
    private boolean annuler ;
    private User user ;

    public static HistoriquePaiementDto fromEntity(HistoriquePaiement historique){
        return HistoriquePaiementDto.builder()
                .id(historique.getId())
                .datePaiement(historique.getDatePaiement())
                .commande(historique.getCommande())
                .annuler(historique.isAnnuler())
                .user(historique.getUser())
                .build() ;
    }

    public static HistoriquePaiement toEntity(HistoriquePaiementDto historique){
        return HistoriquePaiement.builder()
                .id(historique.getId())
                .datePaiement(historique.getDatePaiement())
                .commande(historique.getCommande())
                .annuler(historique.isAnnuler())
                .user(historique.getUser())
                .build() ;
    }
}
