package com.salesianastriano.dam.fleetmanager.repository;

import com.salesianastriano.dam.fleetmanager.model.Mantenimiento;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {

    List<Mantenimiento> findByVehiculo_Id(Long id);

    @Query("select m from Mantenimiento m where m.vehiculo.id = ?1 order by m.fecha DESC")
    Optional<Mantenimiento> findByVehiculo_IdOrderByFechaDesc(Long id);

}
