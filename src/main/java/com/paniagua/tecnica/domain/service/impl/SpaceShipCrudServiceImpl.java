package com.paniagua.tecnica.domain.service.impl;

import com.paniagua.tecnica.application.request.SpaceShipUpdateRequest;
import com.paniagua.tecnica.application.response.SpaceShipResponse;
import com.paniagua.tecnica.domain.exception.SpaceShipNotFoundException;
import com.paniagua.tecnica.domain.model.SpaceShip;
import com.paniagua.tecnica.domain.repository.SpaceShipCrudRepository;
import com.paniagua.tecnica.domain.repository.SpaceShipSearchRepository;
import com.paniagua.tecnica.domain.service.SpaceShipCrudService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SpaceShipCrudServiceImpl implements SpaceShipCrudService {
    private final SpaceShipCrudRepository spaceShipCrudRepository;
    private final SpaceShipSearchRepository spaceShipSearchRepository;

    @Override
    @Transactional
    @CacheEvict(value = "findByName")
    public SpaceShipResponse create(String name) {
        SpaceShip spaceShip = SpaceShip.builder()
                .name(name)
                .build();

        return SpaceShipResponse.fromModel(spaceShipCrudRepository.save(spaceShip));
    }

    @Override
    @Transactional
    @CacheEvict(value = "findByName")
    public SpaceShipResponse update(int spaceShipId, SpaceShipUpdateRequest request) {
        SpaceShip spaceShip = spaceShipSearchRepository.findById(spaceShipId)
                .orElseThrow(() -> new SpaceShipNotFoundException(spaceShipId));

        if (!request.name().isEmpty()) {
            spaceShip.setName(request.name());
        }

        return SpaceShipResponse.fromModel(spaceShipCrudRepository.save(spaceShip));
    }

    @Override
    @Transactional
    @CacheEvict(value = "findByName")
    public void delete(int spaceShipId) {
        SpaceShip spaceShip = spaceShipSearchRepository.findById(spaceShipId)
                .orElseThrow(() -> new SpaceShipNotFoundException(spaceShipId));

        spaceShipCrudRepository.delete(spaceShipId);
    }
}