package com.salesianastriano.dam.fleetmanager.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private String modelo;
    private Double kmActuales;
    private Estado estado;

    @ToString.Exclude
    @OneToMany(mappedBy = "vehiculo", orphanRemoval = true)
    private List<Asignacion> asignaciones = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "vehiculo", orphanRemoval = true)
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return getId() != null && Objects.equals(getId(), vehiculo.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    public void addAsignacion(Asignacion asignacion){
        asignaciones.add(asignacion);
        asignacion.setVehiculo(this);
    }

    public void removeAsignacion(Asignacion asignacion){
        asignaciones.remove(asignacion);
        asignacion.setVehiculo(null);
    }

    public void cambiarEstado(Estado estado){
        this.setEstado(estado);
    }

    public void actualizarKilometraje(Double kilometraje){
        this.setKmActuales(kilometraje);
    }
}
