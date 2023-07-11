package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Matricula;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.EstudianteDTO;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class MatriculaRepositoryImpl implements MatriculaRepository {
      @PersistenceContext 
    private EntityManager entityManager;

        @Override
        public void crear(Matricula matricula) {
            this.entityManager.persist(matricula);
        }

        @Override
        public void actualizar(Matricula matricula) {
            this.entityManager.merge(matricula);
        }

        @Override
        public void borrar(Integer id) {
            this.entityManager.remove(leer(id));
        }

        @Override
        public Matricula leer(Integer id) {
            return this.entityManager.find(Matricula.class,id);
        }

        @Override
        public List<MatriculaDTO> seleccionarTodos() {
            String jpql = "SELECT NEW com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.MatriculaDTO(m.alumno.nombre,m.materia.nombre) FROM Matricula m";
        TypedQuery<MatriculaDTO> query = this.entityManager.createQuery(jpql, MatriculaDTO.class);
        return query.getResultList();
        }  
}
