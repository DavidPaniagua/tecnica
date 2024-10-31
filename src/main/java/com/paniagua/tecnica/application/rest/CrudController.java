package com.paniagua.tecnica.application.rest;

import com.paniagua.tecnica.application.request.SpaceShipUpdateRequest;
import com.paniagua.tecnica.application.response.SpaceShipResponse;
import com.paniagua.tecnica.domain.service.SpaceShipCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "spaceShip/crud")
@RequiredArgsConstructor
public class CrudController {

    private final SpaceShipCrudService spaceShipCrudService;

    @PostMapping(value = "/create")
    public ResponseEntity<SpaceShipResponse> create(@RequestParam String name) {
        SpaceShipResponse response = spaceShipCrudService.create(name);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SpaceShipResponse> update(@RequestParam int spaceShipId,
                                                    @RequestBody SpaceShipUpdateRequest spaceShipUpdateRequest) {
        return ResponseEntity.ok(spaceShipCrudService.update(spaceShipId, spaceShipUpdateRequest));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam int spaceShipId) {
        spaceShipCrudService.delete(spaceShipId);

        return ResponseEntity.noContent().build();
    }
}