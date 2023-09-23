package com.inventory.management.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Commande extends AbstractEntity{

    private String reference ;
    private LocalDateTime dateCommande;
    @Column(name = "annulée")
    private boolean annuler ;
    @ManyToOne
    @JoinColumn(name = "id_commande")
    private Client client ;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user ;
    @OneToMany(mappedBy = "commande")
    private List<HistoriquePaiement> historiquePaiements ;

}
