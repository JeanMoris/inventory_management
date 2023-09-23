package com.inventory.management.dto;

import com.inventory.management.models.Client;
import com.inventory.management.models.Commande;
import com.inventory.management.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CommandeDto {
    private Integer id ;
    private String reference ;
    private LocalDateTime dateCommande;
    private boolean annuler ;
    private Client client ;
    private User user ;

    public static CommandeDto fromEntity(Commande commande){
        return CommandeDto.builder()
                .id(commande.getId())
                .reference(commande.getReference())
                .dateCommande(commande.getDateCommande())
                .annuler(commande.isAnnuler())
                .build() ;
    }

    public static Commande toEntity(CommandeDto commande){
        return Commande.builder()
                .id(commande.getId())
                .reference(commande.getReference())
                .dateCommande(commande.getDateCommande())
                .annuler(commande.isAnnuler())
                .build() ;
    }
}
