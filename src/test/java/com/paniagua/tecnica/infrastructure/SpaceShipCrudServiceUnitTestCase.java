package com.paniagua.tecnica.infrastructure;

import com.paniagua.tecnica.domain.model.SpaceShip;
import com.paniagua.tecnica.domain.repository.SpaceShipCrudRepository;
import com.paniagua.tecnica.domain.repository.SpaceShipSearchRepository;
import com.paniagua.tecnica.domain.service.SpaceShipCrudService;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.Mockito.*;


public abstract class SpaceShipCrudServiceUnitTestCase {
    protected SpaceShipCrudRepository spaceShipCrudRepository;
    protected SpaceShipSearchRepository spaceShipSearchRepository;

    @BeforeEach
    protected void setUp() {
        spaceShipCrudRepository = mock(SpaceShipCrudRepository.class);
        spaceShipSearchRepository = mock(SpaceShipSearchRepository.class);
    }

    public void shouldHaveSavedSpaceShip() {
        verify(spaceShipCrudRepository).save(any(SpaceShip.class));
    }

    public void shouldHaveDeletedSpaceShip() {
        verify(spaceShipCrudRepository).delete(any(Integer.class));
    }

    public void shouldHaveReturnedSpaceShip(SpaceShip spaceShip) {
        when(spaceShipSearchRepository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(spaceShip));
    }
}