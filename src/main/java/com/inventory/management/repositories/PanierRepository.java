package com.inventory.management.repositories;

import com.inventory.management.models.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanierRepository extends JpaRepository<Panier, Integer> {

    List<Panier> findAllByCommandeClientId(Integer id);
    List<Panier> findAllByArticleId(Integer id);
}
