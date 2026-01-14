package com.salesianastriano.dam.fleetmanager.repository;

import com.salesianastriano.dam.fleetmanager.model.Estado;
import com.salesianastriano.dam.fleetmanager.model.Mantenimiento;
import com.salesianastriano.dam.fleetmanager.model.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    boolean existsByMatricula(String matricula);

    @EntityGraph(attributePaths = {"asignaciones", "mantenimientos"})
    Optional<Vehiculo> findById(Long id);

    List<Vehiculo> findByEstado(Estado estado);

    Page<Vehiculo> findAll(Pageable pageable);

}
