package com.inventory.management.repositories;

import com.inventory.management.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
