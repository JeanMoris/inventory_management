package com.inventory.management.services.Impl;

import com.inventory.management.dto.LivrerDto;
import com.inventory.management.models.Livrer;
import com.inventory.management.repositories.LivrerRepository;
import com.inventory.management.services.LivrerService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LivrerServiceImpl implements LivrerService {
    private final LivrerRepository repository ;
    private final ObjectsValidator<LivrerDto> validator ;
    @Override
    public Integer save(LivrerDto dto) {
        validator.validate(dto);
        Livrer livrer = LivrerDto.toEntity(dto) ;
        return repository.save(livrer).getId();
    }

    @Override
    public List<LivrerDto> findAll() {
        return repository.findAll().stream()
                .map(LivrerDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public LivrerDto findById(Integer id) {
        repository.findById(id)
                .map(LivrerDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune livraison n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
