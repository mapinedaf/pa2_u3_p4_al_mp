package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "Provincia")
@Entity
public class Provincia {
    @GeneratedValue(generator = "sec_provincia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_provincia", sequenceName = "sec_provincia", allocationSize = 1)
    @Id
    @Column(name = "prov_id")
    private Integer id;
    @Column(name = "prov_nombre")
    private String nombre;
    @Column(name = "prov_region")
    private String region;
    @Column(name = "prov_capital")
    private String capital;

    @OneToOne(mappedBy = "provincia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Estudiante> estudiantes;
}
