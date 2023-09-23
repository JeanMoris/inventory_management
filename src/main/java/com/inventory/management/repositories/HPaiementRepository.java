package com.inventory.management.repositories;

import com.inventory.management.models.HistoriquePaiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HPaiementRepository extends JpaRepository<HistoriquePaiement, Integer> {
}
