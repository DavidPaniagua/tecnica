package com.paniagua.tecnica.domain.service.impl;

import com.paniagua.tecnica.application.response.SpaceShipResponse;
import com.paniagua.tecnica.domain.exception.SpaceShipNotFoundException;
import com.paniagua.tecnica.domain.model.SpaceShip;
import com.paniagua.tecnica.domain.repository.SpaceShipSearchRepository;
import com.paniagua.tecnica.domain.service.SpaceShipSearchService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpaceShipSearchServiceImpl implements SpaceShipSearchService {
    private final SpaceShipSearchRepository spaceShipSearchRepository;

    @Override
    @Transactional
    public Page<SpaceShipResponse> findAll(Pageable pageable) {
        Page<SpaceShip> spaceShipPage = spaceShipSearchRepository.findAll(pageable);

        List<SpaceShipResponse> spaceShipResponses = spaceShipPage.stream()
                .map(SpaceShipResponse::fromModel)
                .collect(Collectors.toList());

        return new PageImpl<>(spaceShipResponses, pageable, spaceShipPage.getTotalElements());
    }

    @Override
    @Transactional
    public SpaceShipResponse findById(int spaceShipId) {
        return spaceShipSearchRepository.findById(spaceShipId)
                .map(SpaceShipResponse::fromModel)
                .orElseThrow(() -> new SpaceShipNotFoundException(spaceShipId));
    }

    @Override
    @Transactional
    @Cacheable("findByName")
    public List<SpaceShipResponse> findByName(String name) {
        return spaceShipSearchRepository.findByName(name)
                .stream()
                .map(SpaceShipResponse::fromModel)
                .toList();
    }
}