package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.ICuentaBancariaRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
//required es el valor por defecto
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

    @Autowired
    ICuentaBancariaRepository cuentaBancariaRepository;

    @Autowired
    ICuentaBancaria2Service cuentaBancaria2Service;

    @Override
    @Transactional
    public void guardarCuenta(CuentaBancaria cuentaBancaria) {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive()+" Service");

        this.cuentaBancariaRepository.insertar(cuentaBancaria);


    }
    @Transactional(value = TxType.NEVER)
    public void prueba(){
        System.out.println("metodo de prueba");
    }

}
