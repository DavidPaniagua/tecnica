package com.paniagua.tecnica.domain.repository;

import com.paniagua.tecnica.domain.model.SpaceShip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SpaceShipCrudRepository {

    SpaceShip save(SpaceShip spaceShip);

    void delete(int spaceShipId);
}