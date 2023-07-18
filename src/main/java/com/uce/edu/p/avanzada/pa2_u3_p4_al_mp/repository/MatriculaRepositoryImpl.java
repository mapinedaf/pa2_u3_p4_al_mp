package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional

public class MatriculaRepositoryImpl implements IMatriculaRepository{

    @Autowired
    EntityManager entityManager;

    @Override
    public void insertar(Matricula matricula) {
        this.entityManager.persist(matricula);
    }

    @Override
    public List<Matricula> leerMatriculas() {

        String jpql = "SELECT m FROM Matricula m";

        TypedQuery<Matricula> query = this.entityManager.createQuery(jpql, Matricula.class);

        return query.getResultList();
    }
    
}
