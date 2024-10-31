package com.paniagua.tecnica.infrastructure.entity;

import com.paniagua.tecnica.domain.model.SpaceShip;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name = "spaceship")
public class SpaceShipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static SpaceShipEntity fromModel(SpaceShip model) {
        if (model == null)
            return null;

        return SpaceShipEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    public SpaceShip toModel() {
        return SpaceShip.builder()
                .id(id != null ? id : null)
                .name(name != null ? name : null)
                .build();
    }
}