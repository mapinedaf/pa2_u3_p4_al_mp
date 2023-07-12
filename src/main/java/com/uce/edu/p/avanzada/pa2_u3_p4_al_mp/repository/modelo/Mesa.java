package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.math.BigDecimal;

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
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(generator = "sec_mesa", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_mesa", sequenceName = "sec_mesa", allocationSize = 1)
    @Column(name="mesa_id")
    private Integer Id;

    @Column(name="mesa_fabricante")
    private String fabricante;

    @Column(name="mesa_material")
    private String material;

    @Column(name = "mesa_pais_origen")
    private String paisOrigen;

    @Column(name = "mesa_precio")
    private BigDecimal precio;

}
