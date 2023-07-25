package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional()
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{

    @Autowired
    EntityManager entityManager;

    @Override
    public void insertar(CuentaBancaria cuentaBancaria) {
       this.entityManager.persist(cuentaBancaria);
       System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
    }

    @Override
    public void actulizar(CuentaBancaria cuentaBancaria) {
        this.entityManager.merge(cuentaBancaria);
    }
    
}
