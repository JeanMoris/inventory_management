package com.inventory.management.repositories;

import com.inventory.management.models.Article;
import com.inventory.management.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}
