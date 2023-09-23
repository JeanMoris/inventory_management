package com.inventory.management.services.Impl;

import com.inventory.management.dto.CategoryDto;
import com.inventory.management.models.Category;
import com.inventory.management.repositories.CategoryRepository;
import com.inventory.management.services.CategoryService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository ;
    private final ObjectsValidator<CategoryDto> validator ;
    @Override
    public Integer save(CategoryDto dto) {
        validator.validate(dto);
        Category category = CategoryDto.toEntity(dto);
        return repository.save(category).getId();
    }

    @Override
    public List<CategoryDto> findAll() {
        return repository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Integer id) {
        return repository.findById(id)
                .map(CategoryDto::fromEntity).orElseThrow(()-> new EntityNotFoundException(
                        "Aucun client n'est présent dans la base avec l'ID " +id
                ));
    }

    @Override
    public void delete(Integer id) {
     //check to delete
        repository.deleteById(id);
    }
}
