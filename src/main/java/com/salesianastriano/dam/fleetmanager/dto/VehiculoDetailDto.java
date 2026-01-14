package com.salesianastriano.dam.fleetmanager.dto;

import com.salesianastriano.dam.fleetmanager.model.Estado;
import com.salesianastriano.dam.fleetmanager.model.Vehiculo;

import java.util.List;

public record VehiculoDetailDto(Long id, String matricula, String modelo,Double kmActuales, Estado estado, List<AsignacionResponse> asignaciones, List<MantenimientoResponse> mantenimientos) {

    public static VehiculoDetailDto of(Vehiculo vehiculo){
        return new VehiculoDetailDto(
                vehiculo.getId(),
                vehiculo.getMatricula(),
                vehiculo.getModelo(),
                vehiculo.getKmActuales(),
                vehiculo.getEstado(),
                vehiculo.getAsignaciones().stream().map(AsignacionResponse::of).toList(),
                vehiculo.getMantenimientos().stream().map(MantenimientoResponse::of).toList()
        );
    }

}
