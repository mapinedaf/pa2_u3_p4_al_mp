package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="materia")
public class Materia {
    @Id
    @Column(name="mate_id")
    @GeneratedValue(generator = "sec_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_materia", sequenceName = "sec_materia", allocationSize = 1)
    private Integer id;
    @Column(name="mate_nombre")
    private String nombre;

    //representar el muchos de matricula

    @OneToMany(mappedBy = "materia")
    private List<Matricula> matriculas;
}
