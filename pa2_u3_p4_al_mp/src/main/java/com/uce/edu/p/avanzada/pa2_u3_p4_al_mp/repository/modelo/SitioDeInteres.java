package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

@Entity
@Table(name = "sitio_de_interes")

public class SitioDeInteres {


    @Column(name="siti_id")
    @GeneratedValue(generator = "sec_sitio_de_interes", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_sitio_de_interes", sequenceName = "sec_sitio_de_interes", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name="siti_nombre")
    private String nombre;

    @Column(name="siti_ubicacion")
    private String ubicacion;

    @Column(name="siti_hora_apertura")
    private LocalTime horaApertura;

    @Column(name="siti_hora_cierre")
    private LocalTime horaCierre;

    @Column(name="siti_es_aire_libre")
    private Boolean esAireLibre;

    @Column(name="siti_calificacion")
    private Double calificacion;

    @Column(name="siti_costo_de_entrada")
    private BigDecimal costoDeEntrada;

    @Column(name="siti_categoria")
    private String categoria;


    
}
