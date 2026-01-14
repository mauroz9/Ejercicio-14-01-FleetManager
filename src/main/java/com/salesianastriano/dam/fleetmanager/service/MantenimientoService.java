package com.salesianastriano.dam.fleetmanager.service;

import com.salesianastriano.dam.fleetmanager.dto.CreateMantenimientoRequest;
import com.salesianastriano.dam.fleetmanager.model.Estado;
import com.salesianastriano.dam.fleetmanager.model.Mantenimiento;
import com.salesianastriano.dam.fleetmanager.model.Taller;
import com.salesianastriano.dam.fleetmanager.model.Vehiculo;
import com.salesianastriano.dam.fleetmanager.repository.MantenimientoRepository;
import com.salesianastriano.dam.fleetmanager.repository.TallerRepository;
import com.salesianastriano.dam.fleetmanager.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;
    private final VehiculoRepository vehiculoRepository;
    private final TallerRepository tallerRepository;

    public List<Mantenimiento> getAll(){
        return mantenimientoRepository.findAll();
    }

    public Mantenimiento registrarMantenimiento(CreateMantenimientoRequest dto){

        Vehiculo vehiculo = vehiculoRepository.findById(dto.vehiculoId()).orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        Taller taller = tallerRepository.findById(dto.tallerId()).orElseThrow(() -> new RuntimeException("Taller no encontrado"));

        if(vehiculo.getEstado().equals(Estado.ASIGNADO) || vehiculo.getEstado().equals(Estado.EN_MANTENIMIENTO)){
            throw new RuntimeException("No puedes realizar un mantenimiento a un vehículo asignado o en mantenimiento");
        }

        if(dto.kilometraje()<vehiculo.getKmActuales()){
            throw new RuntimeException("Los kilometros son inferiores a los registrados en el vehículo");
        }

        Mantenimiento mantenimiento = Mantenimiento.builder()
                .fecha(dto.fecha())
                .taller(taller)
                .tipo(dto.tipo())
                .vehiculo(vehiculo)
                .kmEnRevision(dto.kilometraje())
                .build();

        vehiculo.actualizarKilometraje(dto.kilometraje());

        return mantenimientoRepository.save(mantenimiento);
    }
}
