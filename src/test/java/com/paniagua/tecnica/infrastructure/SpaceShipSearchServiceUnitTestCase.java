package com.paniagua.tecnica.infrastructure;

import com.paniagua.tecnica.domain.model.SpaceShip;
import com.paniagua.tecnica.domain.repository.SpaceShipSearchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


public abstract class SpaceShipSearchServiceUnitTestCase {
    protected SpaceShipSearchRepository spaceShipSearchRepository;

    @BeforeEach
    protected void setUp() {
        spaceShipSearchRepository = mock(SpaceShipSearchRepository.class);
    }

    public void shouldHaveReturnedSpaceShipFindAll(Pageable pageable, SpaceShip spaceShip) {
        when(spaceShipSearchRepository.findAll(pageable))
                .thenReturn(new PageImpl<>(List.of(spaceShip)));
    }

    public void shouldHaveFindAllSpaceShip() {
        verify(spaceShipSearchRepository).findAll(any(Pageable.class));
    }

    public void shouldHaveReturnedSpaceShip(SpaceShip spaceShip) {
        when(spaceShipSearchRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(spaceShip));
    }

    public void shouldHaveReturnedSpaceShipByName(List<SpaceShip> spaceShips) {
        when(spaceShipSearchRepository.findByName(any(String.class))).thenReturn(spaceShips);
    }
}