package com.salesianastriano.dam.fleetmanager.controller;

import com.salesianastriano.dam.fleetmanager.dto.VehiculoSummaryDto;
import com.salesianastriano.dam.fleetmanager.service.ConductorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConductorController {

    private final ConductorService conductorService;

    @GetMapping("/conductores/{id}/vehiculo-activo")
    public ResponseEntity<VehiculoSummaryDto> getVehiculoAsignado(@PathVariable Long id){
        return ResponseEntity.ok(VehiculoSummaryDto.of(conductorService.getActiveVehiculo(id)));
    }

}
