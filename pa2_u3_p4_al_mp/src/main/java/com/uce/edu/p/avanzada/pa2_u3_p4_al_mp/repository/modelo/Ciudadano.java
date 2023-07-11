package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "ciudadano") //Tabla principal 
public class Ciudadano {

    // cuatro letras identificables

    @Id
    @GeneratedValue(generator = "sec_ciudadano", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_ciudadano", sequenceName = "sec_ciudadano", allocationSize = 1)
    @Column(name = "ciud_id")
    private Integer id;
    @Column(name = "ciud_nombre")
    private String nombre;
    @Column(name = "ciud_apellido")
    private String apellido;
    @Column(name = "ciud_cedula")
    private String cedula;

    @OneToOne(mappedBy = "ciudadano", cascade = CascadeType.ALL)
    private Empleado empleado; //Un ciuidadano tiene un empleado 
}
