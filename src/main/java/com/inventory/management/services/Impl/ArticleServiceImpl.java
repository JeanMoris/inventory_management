package com.inventory.management.services.Impl;

import com.inventory.management.dto.ArticleDto;
import com.inventory.management.models.Article;
import com.inventory.management.repositories.ArticleRepository;
import com.inventory.management.services.ArticleService;
import com.inventory.management.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository ;
    private final ObjectsValidator<ArticleDto> validator ;
    @Override
    public Integer save(ArticleDto dto) {
        validator.validate(dto);
        Article article = ArticleDto.toEntity(dto);
        return repository.save(article).getId();
    }

    @Override
    public List<ArticleDto> findAll() {
        return repository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDto findById(Integer id) {
        return repository.findById(id)
                .map(ArticleDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun client n'est présent dans la base avec l'ID "+ id));
    }

    @Override
    public void delete(Integer id) {
        //check to delete
        repository.deleteById(id);

    }
}
