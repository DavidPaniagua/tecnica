package com.paniagua.tecnica.domain.exception;

import com.paniagua.tecnica.domain.util.SpaceShipErrorConstants;

public class SpaceShipNotFoundException extends RuntimeException {
    public SpaceShipNotFoundException(int spaceShipId) {
        super("%s: %s".formatted(
                SpaceShipErrorConstants.ERR_SPACE_SHIP_NOT_FOUND,
                SpaceShipErrorConstants.ERR_SPACE_SHIP_NOT_FOUND_MSG.formatted(String.valueOf(spaceShipId))
        ));
    }
}