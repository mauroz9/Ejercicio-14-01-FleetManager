package com.salesianastriano.dam.fleetmanager.controller;

import com.salesianastriano.dam.fleetmanager.dto.CreateMantenimientoRequest;
import com.salesianastriano.dam.fleetmanager.dto.MantenimientoResponse;
import com.salesianastriano.dam.fleetmanager.service.MantenimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    @GetMapping("/mantenimientos")
    public ResponseEntity<List<MantenimientoResponse>> getAll(){
        return ResponseEntity.ok(mantenimientoService.getAll().stream().map(MantenimientoResponse::of).toList());
    }

    @PostMapping("/mantenimientos")
    public ResponseEntity<MantenimientoResponse> registrarMantenimiento(@RequestBody CreateMantenimientoRequest dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(MantenimientoResponse.of(mantenimientoService.registrarMantenimiento(dto)));
    }
}
