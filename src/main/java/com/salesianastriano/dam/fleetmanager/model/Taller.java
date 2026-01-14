package com.salesianastriano.dam.fleetmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Taller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ciudad;

    @ToString.Exclude
    @OneToMany(mappedBy = "taller", orphanRemoval = true)
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

}
