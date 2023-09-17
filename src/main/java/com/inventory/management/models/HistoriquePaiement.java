package com.inventory.management.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class HistoriquePaiement extends AbstractEntity{

    private LocalDateTime datePaiement ;
    @ManyToOne
    @JoinColumn(name = "referenceCommande")
    private Commande commande ;
    @Column(name = "annulée")
    private boolean annuler ;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user ;


}
