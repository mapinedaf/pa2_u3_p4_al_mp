package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

public class CuentaBancaria {

    @Id
    @Column(name = "cuba_id")
    private Integer id;
    
    @Column(name = "cuba_numero")
    private String numero;

    @Column(name = "cuba_tipo")
    private Character tipo;

    //mapeo propietario

    @JoinColumn(name = "cuba_propietario_id")
    @ManyToOne()
    private Propietario propietario;
}
