package com.salesianastriano.dam.fleetmanager.dto;

import java.time.LocalDateTime;

public record CreateAsignacionRequest(LocalDateTime fechaInicio, Long idVehiculo, Long idConductor) {
}
