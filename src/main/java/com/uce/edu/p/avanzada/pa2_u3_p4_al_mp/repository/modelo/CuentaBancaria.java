package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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


@Table(name = "cuenta_bancaria")
@Entity

public class CuentaBancaria {
 @Override
    public String toString() {
        return "CuentaBancaria [numero=" + numero + ", tipo=" + tipo + "]";
    }

@Id
    @GeneratedValue(generator = "seq_cuenta_bancaria", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cuenta_bancaria", sequenceName = "seq_cuenta_bancaria",allocationSize = 1)
    @Column(name = "cuba_id")
    private Integer id;
    
    @Column(name = "cuba_numero")
    private String numero;

    @Column(name = "cuba_tipo")
    private Character tipo;

    @Column(name= "cuba_saldo")
    private BigDecimal saldo;
    //mapeo propietario

    @JoinColumn(name = "cuba_propietario_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Propietario propietario;

    @OneToMany(mappedBy = "cuentaEnvio")
    List<Transferencia> transferenciasEnvio;

    @OneToMany(mappedBy = "cuentaRecivo")
    List<Transferencia> transferenciasRecivo;
}
