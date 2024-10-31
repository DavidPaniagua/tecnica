package com.paniagua.tecnica.infrastructure.repository.h2;

import com.paniagua.tecnica.domain.model.SpaceShip;
import com.paniagua.tecnica.domain.repository.SpaceShipCrudRepository;
import com.paniagua.tecnica.domain.repository.SpaceShipSearchRepository;
import com.paniagua.tecnica.infrastructure.entity.SpaceShipEntity;
import com.paniagua.tecnica.infrastructure.repository.SpaceShipJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class H2SpaceShipCrudRepository implements SpaceShipCrudRepository {
    private final SpaceShipJpaRepository spaceShipJpaRepository;

    @Override
    public SpaceShip save(SpaceShip spaceShip) {
        return spaceShipJpaRepository.save(SpaceShipEntity.fromModel(spaceShip)).toModel();
    }

    @Override
    public void delete(int spaceShipId) {
        spaceShipJpaRepository.deleteById(spaceShipId);
    }
}
