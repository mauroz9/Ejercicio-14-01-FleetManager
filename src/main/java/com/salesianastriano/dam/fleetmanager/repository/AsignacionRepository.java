package com.salesianastriano.dam.fleetmanager.repository;

import com.salesianastriano.dam.fleetmanager.model.Asignacion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
    boolean existsByVehiculoIdAndFechaFinIsNull(Long vehiculoId);

    @Override
    @EntityGraph(attributePaths = {"conductor", "vehiculo"})
    List<Asignacion> findAll();

    Optional<Asignacion> findByConductorIdAndFechaFinIsNull(Long id);

    boolean existsByConductorIdAndFechaFinIsNull(Long id);


}
