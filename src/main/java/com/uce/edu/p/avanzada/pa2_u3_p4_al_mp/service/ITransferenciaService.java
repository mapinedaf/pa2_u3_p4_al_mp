package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.CuentaBancaria;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Transferencia;

public interface ITransferenciaService {
    public void realizarTransferencia(CuentaBancaria cEnvio, CuentaBancaria cRecivo, BigDecimal monto);

    public List<Transferencia> reporteTransferencias();
}
