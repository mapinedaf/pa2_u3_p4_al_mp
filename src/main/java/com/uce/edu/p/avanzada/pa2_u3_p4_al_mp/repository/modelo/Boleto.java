package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.math.BigDecimal;

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

@Table(name = "boleto")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Boleto {

    @GeneratedValue(generator = "sec_boleto", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_boleto", sequenceName = "sec_boleto", allocationSize = 1)
    @Id
    @Column(name = "blto_id")
    private Integer id;

    @Column(name="blto_numero")
    private String numero;

    @Column(name = "blto_nombre_pasajero")
    private String nombrePasajero;

    @Column(name= "blto_clase")
    private String clase;

    @Column(name = "blto_asiento")
    private String asiento;


    @Column(name = "blto_puerta_abordaje")
    private String puertaAbordaje;

    @Column(name = "blto_precio")
    private BigDecimal precio;

    @JoinColumn(name = "blto_id_vuelo")
    @ManyToOne
    private Vuelo vuelo;

    @Override
    public String toString() {
        return "Boleto [id=" + id + ", numero=" + numero + ", nombrePasajero=" + nombrePasajero + ", clase=" + clase
                + ", asiento=" + asiento + ", puertaAbordaje=" + puertaAbordaje + ", precio=" + precio + "]";
    }


}
