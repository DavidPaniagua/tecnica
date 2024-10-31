package com.paniagua.tecnica.domain.service;

import com.github.javafaker.Faker;
import com.paniagua.tecnica.application.response.SpaceShipResponse;
import com.paniagua.tecnica.domain.SpaceShipMother;
import com.paniagua.tecnica.domain.model.SpaceShip;
import com.paniagua.tecnica.domain.service.impl.SpaceShipSearchServiceImpl;
import com.paniagua.tecnica.infrastructure.SpaceShipSearchServiceUnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SpaceShipSearchServiceTest extends SpaceShipSearchServiceUnitTestCase {
    static final Faker FAKER = new Faker();
    protected SpaceShipSearchService spaceShipSearchService;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        spaceShipSearchService = new SpaceShipSearchServiceImpl(spaceShipSearchRepository);
    }

    @Test
    void findAllOk() {
        SpaceShip spaceShip = SpaceShipMother.random();
        Pageable pageable = PageRequest.of(FAKER.number().numberBetween(1,111), FAKER.number().numberBetween(1,111));

        shouldHaveReturnedSpaceShipFindAll(pageable, spaceShip);

        spaceShipSearchService.findAll(pageable);

        shouldHaveFindAllSpaceShip();
    }


    @Test
    void findByIdOk() {
        SpaceShip spaceShip = SpaceShipMother.random();

        shouldHaveReturnedSpaceShip(spaceShip);

        SpaceShipResponse response = spaceShipSearchService.findById(spaceShip.getId().intValue());

        assertThat(spaceShip.getId()).isEqualTo(response.getId());
    }

    @Test
    void findByNameOk() {
        List<SpaceShip> spaceShips = List.of(SpaceShipMother.random());

        shouldHaveReturnedSpaceShipByName(spaceShips);

        List<SpaceShipResponse> spaceShipResponses = spaceShipSearchService.findByName(spaceShips.get(0).getName());

        assertThat(spaceShipResponses).usingRecursiveComparison().comparingOnlyFields("name")
                .isEqualTo(spaceShips);
    }
}