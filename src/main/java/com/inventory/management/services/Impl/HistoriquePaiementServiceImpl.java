package com.inventory.management.services.Impl;

import com.inventory.management.dto.HistoriquePaiementDto;
import com.inventory.management.models.HistoriquePaiement;
import com.inventory.management.repositories.HPaiementRepository;
import com.inventory.management.services.HistoriquePaiementService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoriquePaiementServiceImpl implements HistoriquePaiementService {
    private final HPaiementRepository repository ;
    private final ObjectsValidator<HistoriquePaiementDto> validator ;
    @Override
    public Integer save(HistoriquePaiementDto dto) {
        validator.validate(dto);
        HistoriquePaiement historique = HistoriquePaiementDto.toEntity(dto) ;
        return repository.save(historique).getId();
    }

    @Override
    public List<HistoriquePaiementDto> findAll() {
        return repository.findAll().stream()
                .map(HistoriquePaiementDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public HistoriquePaiementDto findById(Integer id) {
        repository.findById(id)
                .map(HistoriquePaiementDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune historique n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
