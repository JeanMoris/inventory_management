package com.inventory.management.dto;

import com.inventory.management.models.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClientDto {
    private Integer id ;
    @NotNull(message = "Le prénom ne doit pas être vide")
    @NotEmpty(message = "Le prénom ne doit pas être vide")
    @NotBlank(message = "Le prénom ne doit pas être vide")
    private String firstname ;
    @NotNull(message = "Le nom ne doit pas être vide")
    @NotEmpty(message = "Le nom ne doit pas être vide")
    @NotBlank(message = "Le nom ne doit pas être vide")
    private String lastname ;
    @NotNull(message = "Le téléphone ne doit pas être vide")
    @NotEmpty(message = "Le téléphone ne doit pas être vide")
    @NotBlank(message = "Le téléphone ne doit pas être vide")
    private String telephone ;
    @NotNull(message = "L'email nom' ne doit pas être vide")
    @NotEmpty(message = "L'email nom' ne doit pas être vide")
    @NotBlank(message = "L'email ne doit pas être vide")
    @Email(message = "L'email n'est pas conforme")
    private String email ;
    private AdresseDto address ;

    public static ClientDto fromEntity(Client client){
        return ClientDto.builder()
                .id(client.getId())
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .telephone(client.getTelephone())
                .email(client.getEmail())
                .address(AdresseDto.fromEntity(client.getAddress()))
                .build() ;
    }

    public static Client toEntity(ClientDto client){
        return Client.builder()
                .id(client.getId())
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .telephone(client.getTelephone())
                .email(client.getEmail())
                .address(AdresseDto.toEntity(client.getAddress()))
                .build() ;
    }
}
