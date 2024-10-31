package com.paniagua.tecnica.application.response;

import com.paniagua.tecnica.domain.model.SpaceShip;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Builder
public class SpaceShipResponse implements Serializable {
    public Long id;
    public String name;

    public static SpaceShipResponse fromModel(SpaceShip model) {
        if (model == null)
            return null;

        return SpaceShipResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}