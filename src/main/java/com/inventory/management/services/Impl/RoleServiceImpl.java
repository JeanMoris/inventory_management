package com.inventory.management.services.Impl;

import com.inventory.management.dto.RoleDto;
import com.inventory.management.dto.CommandeDto;
import com.inventory.management.dto.RoleDto;
import com.inventory.management.models.Client;
import com.inventory.management.models.Role;
import com.inventory.management.repositories.RoleRepository;
import com.inventory.management.services.RoleService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository ;
    private final ObjectsValidator<RoleDto> validator ;
    @Override
    public Integer save(RoleDto dto) {
        validator.validate(dto);
        Role role = RoleDto.toEntity(dto) ;
        return repository.save(role).getId();
    }

    @Override
    public List<RoleDto> findAll() {
        return repository.findAll().stream()
                .map(RoleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(Integer id) {
        repository.findById(id)
                .map(RoleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun rôle n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
