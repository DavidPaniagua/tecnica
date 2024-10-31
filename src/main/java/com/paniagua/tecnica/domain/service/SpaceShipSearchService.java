package com.paniagua.tecnica.domain.service;

import com.paniagua.tecnica.application.response.SpaceShipResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SpaceShipSearchService {
    Page<SpaceShipResponse> findAll(Pageable pageable);

    SpaceShipResponse findById(int spaceShipId);

    List<SpaceShipResponse> findByName(String name);
}