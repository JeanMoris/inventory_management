package com.inventory.management.services.Impl;

import com.inventory.management.dto.CommandeDto;
import com.inventory.management.models.Commande;
import com.inventory.management.repositories.CommandeRepository;
import com.inventory.management.services.CommandeService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository repository ;
    private final ObjectsValidator<CommandeDto> validator ;
    @Override
    public Integer save(CommandeDto dto) {
        validator.validate(dto);
        Commande commande = CommandeDto.toEntity(dto) ;
        return repository.save(commande).getId();
    }

    @Override
    public List<CommandeDto> findAll() {
        return repository.findAll().stream()
                .map(CommandeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CommandeDto findById(Integer id) {
        repository.findById(id)
                .map(CommandeDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
