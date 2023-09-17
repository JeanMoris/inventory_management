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
public class Client extends AbstractEntity{
    @Column(name = "prénoms")
    private String firstname ;
    @Column(name = "nom")
    private String lastname ;
    private String telephone ;
    private String email ;
    @Embedded
    private Address address ;
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes ;
}
