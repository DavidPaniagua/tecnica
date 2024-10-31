package com.paniagua.tecnica.infrastructure.repository;

import com.paniagua.tecnica.infrastructure.entity.SpaceShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpaceShipJpaRepository  extends JpaRepository<SpaceShipEntity, Integer> {

    @Query("SELECT s FROM SpaceShipEntity s WHERE s.name LIKE %:name%")
    List<SpaceShipEntity> findByNameContaining(@Param("name") String name);
}