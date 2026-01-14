package com.salesianastriano.dam.fleetmanager.dto;

import com.salesianastriano.dam.fleetmanager.model.Estado;
import com.salesianastriano.dam.fleetmanager.model.Vehiculo;

public record VehiculoSummaryDto(Long id, String matricula, String modelo, Double kmActuales, Estado estado) {

    public static VehiculoSummaryDto of(Vehiculo vehiculo){
        return new VehiculoSummaryDto(
                vehiculo.getId(),
                vehiculo.getMatricula(),
                vehiculo.getModelo(),
                vehiculo.getKmActuales(),
                vehiculo.getEstado()
        );
    }

}
