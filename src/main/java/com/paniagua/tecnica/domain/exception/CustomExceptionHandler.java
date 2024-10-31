package com.paniagua.tecnica.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleSpaceShipNotFoundException(SpaceShipNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        MainException exception = MainException.builder()
                .error(e.getMessage())
                .timestamp(ZonedDateTime.now(ZoneId.of("Z")))
                .build();

        return new ResponseEntity<>(exception, httpStatus);
    }
}