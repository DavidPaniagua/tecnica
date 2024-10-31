package com.paniagua.tecnica.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpaceShip {
    private Long id;
    private String name;
}