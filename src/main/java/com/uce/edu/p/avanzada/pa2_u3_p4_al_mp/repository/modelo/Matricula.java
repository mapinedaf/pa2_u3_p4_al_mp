package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="matricula")
public class Matricula {
    @Id
    @Column(name="mtla_id")
    @GeneratedValue(generator = "sec_matricula", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_matricula", sequenceName = "sec_matricula", allocationSize = 1)
    private Integer id;
    @Column(name="mtla_numero")
    private String numero;
    @Column(name="mtla_fecha")
    private LocalDate fecha;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="mtla_id_alumno")
    private Alumno alumno;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name="mtla_id_materia")
    private Materia materia;
}