package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class LibroRepositoryImpl  implements LibroRepository{
    @PersistenceContext 
    private EntityManager entityManager;

        @Override
        public void crear(Libro libro) {
            this.entityManager.persist(libro);
        }

        @Override
        public void actualizar(Libro libro) {
            this.entityManager.merge(libro);
        }

        @Override
        public void borrar(Integer id) {
            this.entityManager.remove(leer(id));
        }

        @Override
        public Libro leer(Integer id) {
            return this.entityManager.find(Libro.class,id);
        }
}
