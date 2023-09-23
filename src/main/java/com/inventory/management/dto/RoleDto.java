package com.inventory.management.dto;

import com.inventory.management.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RoleDto {
    private Integer id ;
    private String name ;

    public static RoleDto fromEntity(Role role){
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build() ;
    }

    public static Role toEntity(RoleDto role){
        return Role.builder()
                .id(role.getId())
                .name(role.getName())
                .build() ;
    }
}
