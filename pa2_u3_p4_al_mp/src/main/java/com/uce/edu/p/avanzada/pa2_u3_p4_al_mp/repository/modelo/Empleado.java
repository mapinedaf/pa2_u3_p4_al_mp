package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "empleado") //Tabla secundaria 
public class Empleado {

    @Id
    @GeneratedValue(generator = "sec_empleado", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_empleado", sequenceName = "sec_empleado", allocationSize = 1)
    @Column(name = "empl_id")
    private Integer id;
    @Column(name = "empl_sueldo")
    private BigDecimal sueldo;
    @Column(name = "empl_cargo")
    private String cargo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="empl_ciudadano_id")
    private Ciudadano ciudadano; //relacion uno a uno 

}
