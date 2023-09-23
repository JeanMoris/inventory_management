package com.inventory.management.services.Impl;

import com.inventory.management.dto.FournisseurDto;
import com.inventory.management.models.Fournisseur;

import com.inventory.management.repositories.FournisseurRepository;
import com.inventory.management.services.FournisseurService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {
    private final FournisseurRepository repository ;
    private final ObjectsValidator<FournisseurDto> validator ;
    @Override
    public Integer save(FournisseurDto dto) {
        validator.validate(dto);
        Fournisseur fournisseur = FournisseurDto.toEntity(dto) ;
        return repository.save(fournisseur).getId();
    }

    @Override
    public List<FournisseurDto> findAll() {
        return repository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FournisseurDto findById(Integer id) {
        repository.findById(id)
                .map(FournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun fournisseur n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
