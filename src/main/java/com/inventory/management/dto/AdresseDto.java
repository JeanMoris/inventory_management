package com.inventory.management.dto;

import com.inventory.management.models.Address;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdresseDto {

    private String street ;
    private String city ;
    private String country ;

    public static AdresseDto fromEntity(Address address){
        return AdresseDto.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }

    public static Address toEntity(AdresseDto address){
        return Address.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }
}
