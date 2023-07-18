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

@Table(name = "materia")
@Entity
public class Materia {
    @GeneratedValue(generator = "sec_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_materia", sequenceName = "sec_materia", allocationSize = 1)
    @Id
    @Column(name = "mate_id")
    private Integer id;
    @Column(name = "mate_nombre")
    private String nombre;
    @Column(name = "mate_cantidad_horas")
    private Integer cantidadHoras;
    @Column(name = "mate_codigo")
    private String codigo;


    @OneToMany(mappedBy = "materia")
    private List<Matricula> matriculas;

    @ManyToOne()
    @JoinColumn(name = "mate_id_semestre")
    private Semestre semstre;
}
