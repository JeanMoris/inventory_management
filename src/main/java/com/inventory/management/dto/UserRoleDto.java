package com.inventory.management.dto;

import com.inventory.management.models.Role;
import com.inventory.management.models.User;
import com.inventory.management.models.UserRole;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserRoleDto {
    private Integer id ;
    private User user;
    private Role role;

    public static UserRoleDto fromEntity(UserRole userRole){
        return UserRoleDto.builder()
                .id(userRole.getId())
                .user(userRole.getUser())
                .role(userRole.getRole())
                .build() ;
    }

    public static UserRole toEntity(UserRoleDto userRole){
        return UserRole.builder()
                .id(userRole.getId())
                .user(userRole.getUser())
                .role(userRole.getRole())
                .build() ;
    }
}
