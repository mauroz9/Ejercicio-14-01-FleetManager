package com.salesianastriano.dam.fleetmanager.controller;

import com.salesianastriano.dam.fleetmanager.dto.VehiculoSummaryDto;
import com.salesianastriano.dam.fleetmanager.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping("/vehiculos")
    public ResponseEntity<Page<VehiculoSummaryDto>> getAllPaged(Pageable pageable){
        return ResponseEntity.ok(vehiculoService.getAllPaged(pageable).map(VehiculoSummaryDto::of));
    }
}
