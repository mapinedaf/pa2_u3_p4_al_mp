package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{

    @Autowired
    EntityManager entityManager;
    @Override
    public Estudiante leerPorCedula(String cedula) {

        String jpql = "SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula";

        TypedQuery<Estudiante> query = this.entityManager.createQuery(jpql, Estudiante.class);

        query.setParameter("datoCedula", cedula);

        return query.getSingleResult();
    }
    
}
