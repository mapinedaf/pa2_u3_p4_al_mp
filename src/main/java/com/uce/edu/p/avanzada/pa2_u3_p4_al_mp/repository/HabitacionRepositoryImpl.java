package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements HabitacionRepository{
     @PersistenceContext 
    private EntityManager entityManager;

    @Override
    public void insertar(Habitacion habitacion) {
        this.entityManager.persist(habitacion);
    }

    @Override
    public Habitacion seleccionarPorNumero(Integer id) {
        return this.entityManager.find(Habitacion.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        Habitacion habitacion = this.seleccionarPorNumero(id);
        this.entityManager.remove(habitacion);
        
    }

    @Override
    public void actualizar(Habitacion habitacion) {
        this.entityManager.merge(habitacion);
    }


}
