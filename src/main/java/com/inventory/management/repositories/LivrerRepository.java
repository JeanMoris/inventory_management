package com.inventory.management.repositories;

import com.inventory.management.models.Livrer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrerRepository extends JpaRepository<Livrer, Integer> {
}
