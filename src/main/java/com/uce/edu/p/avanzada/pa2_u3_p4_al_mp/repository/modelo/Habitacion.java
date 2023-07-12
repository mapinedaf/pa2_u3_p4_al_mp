package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.math.BigDecimal;

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

@Table(name="habitacion")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Habitacion {
    
    @GeneratedValue(generator = "seq_habitacion", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_habitacion", sequenceName = "seq_habitacion",allocationSize = 1)
    @Id
    @Column(name = "hab_id")
    private Integer id;
    @Column(name = "hab_numero")
    private String numero;
    @Column(name = "hab_valor")
    private BigDecimal valor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hab_id_hotel")
    private Hotel hotel;


}
