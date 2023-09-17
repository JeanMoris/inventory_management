package com.inventory.management.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur extends AbstractEntity{
    @Column(name = "prenoms")
    private String firstname ;
    @Column(name = "nom")
    private String lastname ;
    private String telephone ;
    private String email ;
    @Embedded
    private Address address ;

    @OneToMany(mappedBy = "fournisseur")
    private List<Approvisionnement> approvisionnements ;


}
