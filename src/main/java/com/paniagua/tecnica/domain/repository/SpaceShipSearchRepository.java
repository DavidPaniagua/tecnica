package com.paniagua.tecnica.domain.repository;

import com.paniagua.tecnica.domain.model.SpaceShip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SpaceShipSearchRepository {
    Page<SpaceShip> findAll(Pageable pageable);

    Optional<SpaceShip> findById(int spaceShipId);

    List<SpaceShip> findByName(String name);
}