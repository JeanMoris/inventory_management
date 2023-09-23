package com.inventory.management.services.Impl;

import com.inventory.management.dto.UserDto;
import com.inventory.management.dto.UserDto;
import com.inventory.management.models.User;
import com.inventory.management.repositories.UserRepository;
import com.inventory.management.repositories.UserRepository;
import com.inventory.management.services.UserService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository ;
    private final ObjectsValidator<UserDto> validator ;
    @Override
    public Integer save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto) ;
        return repository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        repository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur n'est présent dans la base avec l'ID "+ id)) ;
        return null;
    }

    @Override
    public void delete(Integer id) {
        // check to delete
        repository.deleteById(id);

    }
}
