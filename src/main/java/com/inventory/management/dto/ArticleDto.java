package com.inventory.management.dto;

import com.inventory.management.models.Article;
import com.inventory.management.models.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ArticleDto {

    private Integer id ;
    private String reference ;
    private String designation ;
    private Integer stockQuantity ;
    private BigDecimal price ;
    private Category category ;


    public static ArticleDto fromEntity(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .reference(article.getReference())
                .stockQuantity(article.getStockQuantity())
                .price(article.getPrice())
                .category(article.getCategory())
                .build();
    }

    public static Article toEntity(ArticleDto article) {
        return Article.builder()
                .id(article.getId())
                .reference(article.getReference())
                .stockQuantity(article.getStockQuantity())
                .price(article.getPrice())
                .category(article.getCategory())
                .build();
    }
}
