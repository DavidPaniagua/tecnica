package com.paniagua.tecnica.application.rest;

import com.paniagua.tecnica.application.response.SpaceShipResponse;
import com.paniagua.tecnica.domain.service.SpaceShipSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "spaceShip/search")
@RequiredArgsConstructor
public class SearchController {

    private final SpaceShipSearchService spaceShipSearchService;

    @GetMapping(value = "/all")
    public ResponseEntity<Page<SpaceShipResponse>> getAllSpaceShips(@RequestParam(defaultValue = "0") Integer page,
                                                                    @RequestParam(defaultValue = "10") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(spaceShipSearchService.findAll(pageable));
    }

    @GetMapping(value = "/{spaceShipId}")
    public ResponseEntity<SpaceShipResponse> getById(@PathVariable int spaceShipId) {
        return ResponseEntity.ok(spaceShipSearchService.findById(spaceShipId));
    }

    @GetMapping(value = "/byName")
    public ResponseEntity<List<SpaceShipResponse>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(spaceShipSearchService.findByName(name));
    }
}