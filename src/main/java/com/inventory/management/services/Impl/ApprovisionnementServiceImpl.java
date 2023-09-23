package com.inventory.management.services.Impl;

import com.inventory.management.dto.ApprovisionnementDto;
import com.inventory.management.models.Approvisionnement;
import com.inventory.management.repositories.ApprovisionnementRepository;
import com.inventory.management.services.ApprovisionnementService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApprovisionnementServiceImpl implements ApprovisionnementService {
    private final ApprovisionnementRepository repository ;
    private final ObjectsValidator<ApprovisionnementDto> validator ;
    @Override
    public Integer save(ApprovisionnementDto dto) {
        validator.validate(dto);
        Approvisionnement approvisionnement = ApprovisionnementDto.toEntity(dto) ;
        return repository.save(approvisionnement).getId();
    }

    @Override
    public List<ApprovisionnementDto> findAll() {
        return repository.findAll().stream()
                .map(ApprovisionnementDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ApprovisionnementDto findById(Integer id) {
        repository.findById(id)
                .map(ApprovisionnementDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun approvisionnement n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
