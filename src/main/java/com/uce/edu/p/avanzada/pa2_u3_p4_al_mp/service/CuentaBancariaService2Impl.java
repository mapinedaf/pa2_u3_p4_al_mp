package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service

public class CuentaBancariaService2Impl implements ICuentaBancaria2Service {

    @Override
    @Transactional(value = TxType.NEVER)
    public void prueba() {
        System.err.println("------------------------------------");
        System.out.println("metodo de prueba Never");
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

        System.err.println("------------------------------------");

    }

    @Override
    @Transactional(value = TxType.MANDATORY)
    public void prueba2() {
        System.err.println("------------------------------------");
        System.out.println("PRueba MAndatory");
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        System.err.println("------------------------------------");

    }

    @Override
    @Transactional(value = TxType.SUPPORTS)
    public void pruebaSupports() {

        System.err.println("------------------------------------");
        System.out.println("PRueba supports");
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        System.err.println("------------------------------------");
    }

    @Override
    @Transactional(value = TxType.NOT_SUPPORTED)
    public void pruebNotSupported() {
        System.err.println("------------------------------------");
        System.out.println("PRueba Not supported");
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        System.err.println("------------------------------------");
    }

    @Override
        @Transactional()
    public void pruebaRequired() {
            System.err.println("------------------------------------");
        System.out.println("PRueba Nrequired");
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        System.err.println("------------------------------------");
    }

    @Override
    @Transactional(value =  TxType.REQUIRES_NEW)
    public void pruebaRequiresNew() {
                        System.err.println("------------------------------------");
        System.out.println("PRueba Requires new");
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        System.err.println("------------------------------------");
    }
}
