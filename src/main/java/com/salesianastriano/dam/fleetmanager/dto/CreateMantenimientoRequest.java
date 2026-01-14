package com.salesianastriano.dam.fleetmanager.dto;

import java.time.LocalDateTime;

public record CreateMantenimientoRequest(String tipo, LocalDateTime fecha, Long tallerId, Long vehiculoId, Double kilometraje) {
}
