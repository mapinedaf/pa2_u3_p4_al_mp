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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder    


@Table(name = "propietario")
@Entity
public class Propietario {

    @GeneratedValue(generator = "seq_propietario", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_propietario", sequenceName = "seq_propietario",allocationSize = 1)
    @Id
    @Column(name = "prop_id")
    private Integer id;

    @Column(name = "prop_nombre")
    private String nombre;

        @Column(name = "prop_apellido")
    private String apellido;

    @Column(name = "prop_cedula")
    private String cedula;

    @OneToMany(mappedBy = "propietario")
    List<CuentaBancaria> cuentas;

    
}
