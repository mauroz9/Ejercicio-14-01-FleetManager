package com.salesianastriano.dam.fleetmanager.repository;

import com.salesianastriano.dam.fleetmanager.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
}
