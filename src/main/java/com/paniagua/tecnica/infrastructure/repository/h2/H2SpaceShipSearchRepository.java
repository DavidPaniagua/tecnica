package com.paniagua.tecnica.infrastructure.repository.h2;

import com.paniagua.tecnica.domain.model.SpaceShip;
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
public class H2SpaceShipSearchRepository implements SpaceShipSearchRepository {

    private final SpaceShipJpaRepository spaceShipJpaRepository;

    @Override
    public Page<SpaceShip> findAll(Pageable pageable) {
        return spaceShipJpaRepository.findAll(pageable).map(SpaceShipEntity::toModel);
    }

    @Override
    public Optional<SpaceShip> findById(int spaceShipId) {
        return spaceShipJpaRepository.findById(spaceShipId).map(SpaceShipEntity::toModel);
    }

    @Override
    public List<SpaceShip> findByName(String name) {
        return spaceShipJpaRepository.findByNameContaining(name)
                .stream()
                .map(SpaceShipEntity::toModel)
                .toList();
    }
}
