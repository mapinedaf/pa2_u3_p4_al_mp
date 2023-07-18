package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Semestre;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SemestreRepositoryImpl implements ISemestreRepository {

    @Autowired
    EntityManager entityManager;
    @Override
    public void insertar(Semestre semstre) {
        this.entityManager.persist(semstre);
    }
    
}
