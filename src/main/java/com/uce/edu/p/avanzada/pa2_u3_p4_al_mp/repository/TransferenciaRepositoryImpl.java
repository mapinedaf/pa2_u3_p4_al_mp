package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional(value =  TxType.MANDATORY)
    public void insertar(Transferencia transferencia) {

        this.entityManager.persist(transferencia);

    }

    @Override
    @Transactional(value= TxType.REQUIRED)
    public List<Transferencia> leerTransferencias() {
        String jpql = "SELECT t FROM Transferencia t";

        TypedQuery<Transferencia> mQuery = this.entityManager.createQuery(jpql, Transferencia.class);

        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        return mQuery.getResultList();
    }

}
