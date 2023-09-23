package com.inventory.management.dto;

import com.inventory.management.models.Article;
import com.inventory.management.models.Category;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Integer id ;
    private String description ;
    private List<Article> articles ;

    public static CategoryDto fromEntity(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .description(category.getDescription())
                .articles(category.getArticles())
                .build() ;
    }

    public static Category toEntity(CategoryDto category){
        return Category.builder()
                .id(category.getId())
                .description(category.getDescription())
                .articles(category.getArticles())
                .build() ;
    }
}
