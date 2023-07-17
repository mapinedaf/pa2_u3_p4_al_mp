package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

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
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transferencia")
@Entity
@ToString
public class Transferencia {

    @GeneratedValue(generator = "seq_transferencia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
    @Id
    @Column(name = "trsf_id")
    private Integer id;
    @Column(name = "trsf_fecha")
    private LocalDate fecha;
    @Column(name = "trsf_monto")
    private BigDecimal monto;

    // mapeo cuentas
    @JoinColumn(name = "cuba_cuenta_envio")
    @ManyToOne()
    private CuentaBancaria cuentaEnvio;
    @JoinColumn(name = "cuba_cuenta_recivo")
    @ManyToOne()
    private CuentaBancaria cuentaRecivo;

}
