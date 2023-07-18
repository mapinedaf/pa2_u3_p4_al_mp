package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "estudiante")
@Entity
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

    @OneToMany(mappedBy = "estudiante")
    private List<Matricula> matriculas;

    @ManyToOne()
    @JoinColumn(name = "estu_id_provincia")
    private Provincia provincia;

}
