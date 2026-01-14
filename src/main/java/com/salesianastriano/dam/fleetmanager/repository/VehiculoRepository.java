package com.salesianastriano.dam.fleetmanager.repository;

import com.salesianastriano.dam.fleetmanager.model.Asignacion;
import com.salesianastriano.dam.fleetmanager.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    boolean existsByAsignacionesFechaFinNull();
}
