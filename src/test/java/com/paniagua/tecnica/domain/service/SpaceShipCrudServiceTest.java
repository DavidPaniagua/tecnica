package com.paniagua.tecnica.domain.service;

import com.github.javafaker.Faker;
import com.paniagua.tecnica.application.request.SpaceShipUpdateRequest;
import com.paniagua.tecnica.domain.SpaceShipMother;
import com.paniagua.tecnica.domain.model.SpaceShip;
import com.paniagua.tecnica.domain.service.impl.SpaceShipCrudServiceImpl;
import com.paniagua.tecnica.infrastructure.SpaceShipCrudServiceUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpaceShipCrudServiceTest extends SpaceShipCrudServiceUnitTestCase {
    static final Faker FAKER = new Faker();
    protected SpaceShipCrudService spaceShipCrudService;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        spaceShipCrudService = new SpaceShipCrudServiceImpl(spaceShipCrudRepository, spaceShipSearchRepository);
    }

    @Test
    void createOk() {
        SpaceShip spaceShip = SpaceShipMother.random();

        spaceShipCrudService.create(spaceShip.getName());

        shouldHaveSavedSpaceShip();
    }

    @Test
    void updateOk() {
        SpaceShip spaceShip = SpaceShipMother.random();
        SpaceShipUpdateRequest spaceShipUpdateRequest = new SpaceShipUpdateRequest(spaceShip.getName());

        shouldHaveReturnedSpaceShip(spaceShip);

        spaceShipCrudService.update(FAKER.number().numberBetween(1,111), spaceShipUpdateRequest);

        shouldHaveSavedSpaceShip();
    }

    @Test
    void deleteOk() {
        SpaceShip spaceShip = SpaceShipMother.random();

        shouldHaveReturnedSpaceShip(spaceShip);

        spaceShipCrudService.delete(FAKER.number().numberBetween(1,111));

        shouldHaveDeletedSpaceShip();
    }
}