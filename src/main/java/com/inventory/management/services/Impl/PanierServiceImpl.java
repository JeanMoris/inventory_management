package com.inventory.management.services.Impl;

import com.inventory.management.dto.PanierDto;
import com.inventory.management.dto.PanierDto;
import com.inventory.management.models.Commande;
import com.inventory.management.models.Panier;
import com.inventory.management.repositories.PanierRepository;
import com.inventory.management.services.PanierService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PanierServiceImpl implements PanierService {
    private final PanierRepository repository ;
    private final ObjectsValidator<PanierDto> validator ;
    @Override
    public Integer save(PanierDto dto) {
        validator.validate(dto);
        Panier panier = PanierDto.toEntity(dto) ;
        return repository.save(panier).getId();
    }

    @Override
    public List<PanierDto> findAll() {
        return repository.findAll().stream()
                .map(PanierDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PanierDto findById(Integer id) {
        repository.findById(id)
                .map(PanierDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
