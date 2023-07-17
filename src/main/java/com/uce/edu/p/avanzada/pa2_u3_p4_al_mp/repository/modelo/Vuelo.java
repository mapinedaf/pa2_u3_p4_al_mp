package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

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


@Entity
@Table(name = "vuelo")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Vuelo {
    
    @GeneratedValue(generator = "sec_vuelo", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_vuelo", sequenceName = "sec_vuelo", allocationSize = 1)
    @Id
    @Column(name = "vuel_id")
    private Integer id;

    @Column(name = "vuel_codigo")
    private String codigo;

    @Column(name = "vuel_origen")
    private String origen;

    @Column(name = "vuel_destino")
    private String destino;

    @Column(name = "vuel_identificado_avion")
    private String identificadorAvion;


    @OneToMany(mappedBy = "vuelo", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    private List<Boleto> boletos;


    @Override
    public String toString() {
        return "Vuelo [id=" + id + ", codigo=" + codigo + ", origen=" + origen + ", destino=" + destino
                + ", identificadorAvion=" + identificadorAvion + "]";
    }



  
}
