package com.salesianastriano.dam.fleetmanager.service;

import com.salesianastriano.dam.fleetmanager.model.Asignacion;
import com.salesianastriano.dam.fleetmanager.model.Vehiculo;
import com.salesianastriano.dam.fleetmanager.repository.AsignacionRepository;
import jakarta.servlet.annotation.ServletSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConductorService {

    private final AsignacionRepository asignacionRepository;

    public Vehiculo getActiveVehiculo(Long id){
       Optional<Asignacion> asignacion = asignacionRepository.findByConductorIdAndFechaFinIsNull(id);

       if(asignacion.isEmpty()){
           throw new RuntimeException("El conductor no tiene asignaciones activas");
       }

       return asignacion.get().getVehiculo();
    }

}
