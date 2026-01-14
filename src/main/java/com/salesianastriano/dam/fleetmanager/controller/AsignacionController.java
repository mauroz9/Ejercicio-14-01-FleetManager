package com.salesianastriano.dam.fleetmanager.controller;

import com.salesianastriano.dam.fleetmanager.dto.AsignacionResponse;
import com.salesianastriano.dam.fleetmanager.dto.CreateAsignacionRequest;
import com.salesianastriano.dam.fleetmanager.model.Asignacion;
import com.salesianastriano.dam.fleetmanager.service.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AsignacionController {

    private final AsignacionService asignacionService;

    @GetMapping("/asignaciones")
    public ResponseEntity<List<AsignacionResponse>> getAll(){
        return ResponseEntity.ok(asignacionService.getAll().stream().map(AsignacionResponse::of).toList());
    }

    @PostMapping("/asignaciones")
    public ResponseEntity<AsignacionResponse> crearAsignacion(@RequestBody CreateAsignacionRequest dto){

        return ResponseEntity.status(HttpStatus.CREATED).body(AsignacionResponse.of(asignacionService.crearAsignacion(dto)));

    }

    @PutMapping("/asignaciones/{id}/cerrar")
    public ResponseEntity<AsignacionResponse> cerrarAsignacion(@PathVariable Long id){

        return ResponseEntity.ok(AsignacionResponse.of(asignacionService.cerrarAsignacion(id)));

    }
}
