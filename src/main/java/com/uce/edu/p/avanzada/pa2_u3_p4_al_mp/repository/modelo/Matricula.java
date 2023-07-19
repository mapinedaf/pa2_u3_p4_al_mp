package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder

@ToString

@Table(name = "matricula")
@Entity
public class Matricula {


    @GeneratedValue(generator = "sec_matricula", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_matricula", sequenceName = "sec_matricula",allocationSize = 1)
    @Id
    @Column(name="matr_id")
    private Integer id;
    @Column(name = "matr_numero")
    private String numero;
    @Column(name = "matr_fecha")
    private LocalDate fecha;
    @Column(name= "matr_hora")
    private LocalTime hora;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matr_id_estudiante")
    private Estudiante estudiante;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "matr_id_materia")
    private Materia materia;
    
}
