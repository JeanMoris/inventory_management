package com.inventory.management.services.Impl;

import com.inventory.management.dto.ClientDto;
import com.inventory.management.models.Client;
import com.inventory.management.repositories.ClientRepository;
import com.inventory.management.services.ClientService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository ;
    private final ObjectsValidator<ClientDto> validator ;
    @Override
    public Integer save(ClientDto dto) {
        validator.validate(dto);
        Client client = ClientDto.toEntity(dto) ;
        return repository.save(client).getId();
    }

    @Override
    public List<ClientDto> findAll() {
        return repository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Integer id) {
        repository.findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun client n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
