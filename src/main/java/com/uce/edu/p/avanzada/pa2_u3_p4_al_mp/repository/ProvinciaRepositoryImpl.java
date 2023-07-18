package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Provincia;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProvinciaRepositoryImpl implements IProvinciaRepository {

    @Autowired
    EntityManager entityManager;
    @Override
    public void insertar(Provincia provincia) {
        this.entityManager.persist(provincia);
    }
    
}
