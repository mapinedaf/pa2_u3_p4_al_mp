package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository;

import org.springframework.stereotype.Repository;
import com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRespositoryImpl implements IMatriculaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Matricula matricula) {
        this.entityManager.persist(matricula);
    }
    
}
