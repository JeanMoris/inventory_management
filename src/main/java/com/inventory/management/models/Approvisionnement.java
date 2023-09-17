package com.inventory.management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Approvisionnement extends AbstractEntity{

    private String reference ;
    private LocalDateTime dateLivraison ;
    private BigDecimal montantFacture ;
    @ManyToOne
    @JoinColumn(name = "id_fournisseur")
    private Fournisseur fournisseur ;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user ;


}
