package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor

// Setter y Getter
@Setter
@Getter

// Metodo toString
@ToString

// Builder
@Builder

// Configuracion DDL
@Table(name = "estudiante")
@Entity

@NamedQueries({
        @NamedQuery(name = "Estudiante.buscaPorApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido"),
        @NamedQuery(name = "Estudiante.buscaPorNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre") })

@NamedNativeQueries({
        @NamedNativeQuery(name = "Estudiante.buscarApellidoNative", query = "SELECT * FROM estudiante WHERE estu_apellido = :datoApellido", resultClass = Estudiante.class),
        @NamedNativeQuery(name = "Estudiante.buscarNombreNative", query = "SELECT * FROM estudiante WHERE estu_nombre = :datoNombre", resultClass = Estudiante.class)
})

public class Estudiante {

    @GeneratedValue(generator = "sec_estudiante", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_estudiante", sequenceName = "sec_estudiante", allocationSize = 1)
    @Id
    @Column(name = "estu_id")
    private Integer id;

    @Column(name = "estu_cedula")
    private String cedula;

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private String apellido;

    @Column(name = "estu_peso")
    private Double peso;

}
