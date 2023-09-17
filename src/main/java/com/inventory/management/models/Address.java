package com.inventory.management.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Table(name = "Adresse")
public class Address{
    @Column(name = "rue")
    private String street ;
    @Column(name = "ville")
    private String city ;
    @Column(name = "pays")
    private String country ;

}
