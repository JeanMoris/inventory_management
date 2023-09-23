package com.inventory.management.repositories;

import com.inventory.management.models.Approvisionnement;
import com.inventory.management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement, Integer> {

    User findAllById(Integer id) ;
    @Query("from Approvisionnement a inner join User u on a.user.id = u.id where u.id=:userId")
    List<Approvisionnement> findAllByUserId(@Param("userId") Integer id);
}
