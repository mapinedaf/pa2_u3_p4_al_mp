package com.example.pa2_u3_p4_al_mp.tarea12_banco.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.pa2_u3_p4_al_mp.Pa2U3P4AlMpApplication;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository{
    private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4AlMpApplication.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional(value = TxType.NEVER)
    public void insertar(Propietario propietario) {
LOG.info("Hilo repository: "+ Thread.currentThread().getName());
        System.out.println("XDDD");
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        this.entityManager.persist(propietario);
    }

    @Override
    public void actulizar(Propietario propietario) {
        this.entityManager.merge(propietario);
    }

    @Override
    public void eliminar(String id) {
        Propietario prop = this.seleccionarPorId(id);
        this.entityManager.remove(prop);
    }

    @Override
    public Propietario seleccionarPorId(String id) {
        return this.entityManager.find(Propietario.class, id);
    }
    
}
