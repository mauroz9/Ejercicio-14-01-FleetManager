package com.salesianastriano.dam.fleetmanager.service;

import com.salesianastriano.dam.fleetmanager.dto.CreateAsignacionRequest;
import com.salesianastriano.dam.fleetmanager.model.Asignacion;
import com.salesianastriano.dam.fleetmanager.model.Conductor;
import com.salesianastriano.dam.fleetmanager.model.Estado;
import com.salesianastriano.dam.fleetmanager.model.Vehiculo;
import com.salesianastriano.dam.fleetmanager.repository.AsignacionRepository;
import com.salesianastriano.dam.fleetmanager.repository.ConductorRepostory;
import com.salesianastriano.dam.fleetmanager.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionService {

    private final AsignacionRepository asignacionRepository;
    private final ConductorRepostory conductorRepostory;
    private final VehiculoRepository vehiculoRepository;

    public List<Asignacion> getAll(){
        return asignacionRepository.findAll();
    }

    public Asignacion crearAsignacion(CreateAsignacionRequest dto){
        Conductor conductor = conductorRepostory.findById(dto.idConductor()).orElseThrow(() -> new RuntimeException("Conductor no encontrado"));
        Vehiculo vehiculo = vehiculoRepository.findById(dto.idVehiculo()).orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));

        if(dto.fechaInicio().isBefore(LocalDateTime.now())){
            throw new RuntimeException("No puedes crear una asignación en el pasado");
        }

        if(vehiculo.getEstado().equals(Estado.ASIGNADO) || vehiculo.getEstado().equals(Estado.EN_MANTENIMIENTO)){
            throw new RuntimeException("No puedes asignar un vehiclo ya asignado o en mantenimiento");
        }

        if(asignacionRepository.existsByVehiculoIdAndFechaFinIsNull(dto.idVehiculo())){
            throw new RuntimeException("Ya existe una asignación activa");
        }



        Asignacion asignacion = Asignacion.builder()
                .conductor(conductor)
                .fechaInicio(dto.fechaInicio())
                .fechaFin(null)
                .vehiculo(vehiculo)
                .build();

        conductor.addAsignacion(asignacion);
        vehiculo.addAsignacion(asignacion);

        vehiculo.cambiarEstado(Estado.ASIGNADO);

        return asignacionRepository.save(asignacion);
    }

    public Asignacion cerrarAsignacion(Long asignacionId){
        Asignacion asignacion = asignacionRepository.findById(asignacionId).orElseThrow(() -> new RuntimeException("Asignación no encontrada"));
        asignacion.cerrarAsignacion();

        asignacion.getVehiculo().cambiarEstado(Estado.DISPONIBLE);

        return asignacionRepository.save(asignacion);
    }
}
