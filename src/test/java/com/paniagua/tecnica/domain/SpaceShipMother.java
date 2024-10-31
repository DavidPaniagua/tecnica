package com.paniagua.tecnica.domain;

import com.github.javafaker.Faker;
import com.paniagua.tecnica.domain.model.SpaceShip;

public class SpaceShipMother {
    private static final Faker faker = new Faker();

    public static SpaceShip create(Long id, String name) {
        return SpaceShip.builder()
                .id(id)
                .name(name)
                .build();
    }

    public static SpaceShip random() {
        //Generate int and cast to long for avoid invalid parse
        return create((long) faker.number().numberBetween(1, 111),
                faker.leagueOfLegends().summonerSpell());
    }
}