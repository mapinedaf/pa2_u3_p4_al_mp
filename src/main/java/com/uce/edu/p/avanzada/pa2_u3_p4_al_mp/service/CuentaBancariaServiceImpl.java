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
    @Transactional(value =  TxType.NEVER)
    public void guardarCuenta(CuentaBancaria cuentaBancaria) {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive()+" Service");
        //cuentaBancaria2Service.prueba();
        //cuentaBancaria2Service.prueba2();
        //cuentaBancaria2Service.pruebaSupports();
        //cuentaBancaria2Service.pruebNotSupported();
        //this.cuentaBancariaRepository.insertar(cuentaBancaria);
        cuentaBancaria2Service.pruebaRequired();
        cuentaBancaria2Service.pruebaRequiresNew();

    }
    @Transactional(value = TxType.NEVER)
    public void prueba(){
        System.out.println("metodo de prueba");
    }

}
