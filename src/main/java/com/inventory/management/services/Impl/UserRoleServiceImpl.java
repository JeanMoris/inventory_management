package com.inventory.management.services.Impl;

import com.inventory.management.dto.UserRoleDto;
import com.inventory.management.models.UserRole;
import com.inventory.management.repositories.UserRoleRepository;
import com.inventory.management.services.UserRoleService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository repository ;
    private final ObjectsValidator<UserRoleDto> validator ;
    @Override
    public Integer save(UserRoleDto dto) {
        validator.validate(dto);
        UserRole userRole = UserRoleDto.toEntity(dto) ;
        return repository.save(userRole).getId();
    }

    @Override
    public List<UserRoleDto> findAll() {
        return repository.findAll().stream()
                .map(UserRoleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleDto findById(Integer id) {
        repository.findById(id)
                .map(UserRoleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune userRole n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
