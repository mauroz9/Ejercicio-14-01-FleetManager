package com.salesianastriano.dam.fleetmanager.dto;

import com.salesianastriano.dam.fleetmanager.model.Mantenimiento;
import com.salesianastriano.dam.fleetmanager.model.Taller;
import com.salesianastriano.dam.fleetmanager.model.Vehiculo;

import java.time.LocalDateTime;

public record MantenimientoResponse(Long id, LocalDateTime fecha, String tipo, Double kmEnRevision, Long idTaller, Long idVehiculo, String matriculaVehiculo) {

    public static MantenimientoResponse of(Mantenimiento m){
        return new MantenimientoResponse(
                m.getId(),
                m.getFecha(),
                m.getTipo(),
                m.getKmEnRevision(),
                m.getTaller().getId(),
                m.getVehiculo().getId(),
                m.getVehiculo().getMatricula()
        );
    }

}
