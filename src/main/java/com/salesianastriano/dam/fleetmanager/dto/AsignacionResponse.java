package com.salesianastriano.dam.fleetmanager.dto;

import com.salesianastriano.dam.fleetmanager.model.Asignacion;
import java.time.LocalDateTime;

public record AsignacionResponse(
        Long id,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        Long idConductor,
        String nombreConductor,
        Long idVehiculo,
        String matriculaVehiculo
) {
    public static AsignacionResponse of(Asignacion a) {
        return new AsignacionResponse(
                a.getId(),
                a.getFechaInicio(),
                a.getFechaFin(),
                (a.getConductor() != null) ? a.getConductor().getId() : null,
                (a.getConductor() != null) ? a.getConductor().getNombre() : null,
                (a.getVehiculo() != null) ? a.getVehiculo().getId() : null,
                (a.getVehiculo() != null) ? a.getVehiculo().getMatricula() : null
        );
    }
}