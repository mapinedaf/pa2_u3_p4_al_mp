package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Ciudadano;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
@Transactional  
public class CiudadanoRepsitoryImpl implements CiudadanoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Ciudadano ciudadano) {
        this.entityManager.persist(ciudadano);
    }

    @Override
    public Ciudadano leer(Integer id) {
        return this.entityManager.find(Ciudadano.class,id);
    }

    @Override
    public void actualizar(Ciudadano ciudadano) {
        this.entityManager.merge(ciudadano);
    }

    @Override
    public void borrar(Integer id) {
        this.entityManager.remove(leer(id));
    }
    
}
