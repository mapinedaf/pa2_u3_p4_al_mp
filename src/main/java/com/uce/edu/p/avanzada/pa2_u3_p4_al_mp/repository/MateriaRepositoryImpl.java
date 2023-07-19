package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class MateriaRepositoryImpl  implements IMateriaRepository{
    @Autowired
    EntityManager entityManager;

    @Override
    public Materia leerPorCodigo(String codigo) {
        String jpql = "SELECT m FROM Materia m WHERE m.codigo = :datoCodigo";

        TypedQuery<Materia> query = this.entityManager.createQuery(jpql, Materia.class);

        query.setParameter("datoCodigo", codigo);

        return query.getSingleResult();
    }
    
}
