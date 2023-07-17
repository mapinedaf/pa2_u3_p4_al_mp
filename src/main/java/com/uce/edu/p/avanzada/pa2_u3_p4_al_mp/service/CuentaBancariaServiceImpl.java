package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.ICuentaBancariaRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.CuentaBancaria;
@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

    @Autowired
    ICuentaBancariaRepository cuentaBancariaRepository;
    @Override
    public void guardarCuenta(CuentaBancaria cuentaBancaria) {
        this.cuentaBancariaRepository.insertar(cuentaBancaria);
    }
    
}
