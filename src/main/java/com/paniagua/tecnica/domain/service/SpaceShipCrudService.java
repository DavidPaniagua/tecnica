package com.paniagua.tecnica.domain.service;

import com.paniagua.tecnica.application.request.SpaceShipUpdateRequest;
import com.paniagua.tecnica.application.response.SpaceShipResponse;

public interface SpaceShipCrudService {
    SpaceShipResponse create(String name);

    SpaceShipResponse update(int spaceShipId, SpaceShipUpdateRequest request);

    void delete(int spaceShipId);
}