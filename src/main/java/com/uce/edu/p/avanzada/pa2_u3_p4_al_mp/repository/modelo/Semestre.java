package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "semestre")
@Entity
public class Semestre {
    @GeneratedValue(generator = "sec_semstre", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_semstre", sequenceName = "sec_semstre", allocationSize = 1)
    @Id
    @Column(name = "smst_id")
    private Integer id;
    @Column(name = "smst_nivel_semestre")
    private String nivelSemetre;
    @Column(name = "smst_fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "smst_fecha_fin")
    private LocalDate fechaFin;

    @OneToMany(mappedBy = "semestre",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Materia> materias;
}
