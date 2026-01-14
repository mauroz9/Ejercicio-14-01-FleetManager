package com.salesianastriano.dam.fleetmanager.service;

import com.salesianastriano.dam.fleetmanager.model.Vehiculo;
import com.salesianastriano.dam.fleetmanager.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;

    public Page<Vehiculo> getAllPaged(Pageable pageable){
        return vehiculoRepository.findAll(pageable);
    }


}
