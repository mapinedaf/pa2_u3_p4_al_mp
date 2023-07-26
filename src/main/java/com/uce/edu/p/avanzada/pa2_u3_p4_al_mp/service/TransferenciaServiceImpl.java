package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.ICuentaBancariaRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.ITransferenciaRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.CuentaBancaria;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Transferencia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

    @Autowired
    ITransferenciaRepository tRepository;

    @Autowired
    ICuentaBancariaRepository cuentaBancariaRepository;

    @Override
    public List<Transferencia> reporteTransferencias() {
        return this.tRepository.leerTransferencias();
    }

    @Override
    @Transactional(value = TxType.REQUIRED)
    public void realizarTransferencia(CuentaBancaria cEnvio, CuentaBancaria cRecivo, BigDecimal monto) {

        cEnvio.setSaldo(cEnvio.getSaldo().subtract(monto));
        cuentaBancariaRepository.actulizar(cEnvio);
        cRecivo.setSaldo(cEnvio.getSaldo().add(monto));
        cuentaBancariaRepository.actulizar(cRecivo);
        Transferencia transferencia = Transferencia
                .builder()
                .monto(monto)
                .cuentaEnvio(cEnvio)
                .cuentaRecivo(cRecivo)
                .fecha(LocalDate.now())
                .build();
        tRepository.insertar(transferencia);

        if (cEnvio.getSaldo().compareTo(BigDecimal.valueOf(0)) == -1) {
            throw new RuntimeException();

        }

    }

}
