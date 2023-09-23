package com.inventory.management.dto;

import com.inventory.management.models.Address;
import com.inventory.management.models.Fournisseur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class FournisseurDto {

    private Integer id ;
    private String firstname ;
    private String lastname ;
    private String telephone ;
    private String email ;
    private Address address ;

    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .firstname(fournisseur.getFirstname())
                .lastname(fournisseur.getLastname())
                .telephone(fournisseur.getTelephone())
                .email(fournisseur.getEmail())
                .address(fournisseur.getAddress())
                .build() ;
    }

    public static Fournisseur toEntity(FournisseurDto fournisseur){
        return Fournisseur.builder()
                .id(fournisseur.getId())
                .firstname(fournisseur.getFirstname())
                .lastname(fournisseur.getLastname())
                .telephone(fournisseur.getTelephone())
                .email(fournisseur.getEmail())
                .address(fournisseur.getAddress())
                .build() ;
    }
}
