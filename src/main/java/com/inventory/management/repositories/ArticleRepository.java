package com.inventory.management.repositories;

import com.inventory.management.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> findAllByCategoryId(Long idCategory);
    @Query("from Article where reference = :reference")
    Article findByReference(String reference) ;

    @Query
            ("from Article a inner join Category c on a.category.id = c.id " +
                    "where c.description = :description")
    List<Article> findByCategoryDescription(String description) ;

}
