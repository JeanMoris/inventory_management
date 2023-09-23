package com.inventory.management.repositories;

import com.inventory.management.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.commandes")
    List<Client> findAllClientsWithCommandes();

}
