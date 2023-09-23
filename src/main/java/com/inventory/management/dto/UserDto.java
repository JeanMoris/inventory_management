package com.inventory.management.dto;

import com.inventory.management.models.Address;
import com.inventory.management.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {
    private Integer id ;
    private String firstname ;
    private String lastname ;
    private String telephone ;
    private String email ;
    private Address address ;

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .telephone(user.getTelephone())
                .email(user.getEmail())
                .address(user.getAddress())
                .build() ;
    }

    public static User toEntity(UserDto user){
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .telephone(user.getTelephone())
                .email(user.getEmail())
                .address(user.getAddress())
                .build() ;
    }
}
