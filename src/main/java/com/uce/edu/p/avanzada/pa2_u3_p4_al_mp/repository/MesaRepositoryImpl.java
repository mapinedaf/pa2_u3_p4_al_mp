package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Mesa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MesaRepositoryImpl implements MesaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Mesa Mesa) {
        this.entityManager.persist(Mesa);
    }

    @Override
    public Mesa leer(Integer id) {
        return this.entityManager.find(Mesa.class, id);
    }

    @Override
    public void actualizar(Mesa mesa) {
        this.entityManager.merge(mesa);
    }

    @Override
    public void borrar(Integer id) {
        this.entityManager.remove(leer(id));
    }

    @Override
    public Mesa seleccionarPorFabricante(String fabricante) {
        Query query = this.entityManager
                .createQuery("SELECT m FROM Mesa m WHERE m.fabricante = :datoFabricante");
        query.setParameter("datoFabricante", fabricante);
        return (Mesa) query.getSingleResult(); // casteo
    }

    @Override
    public Mesa seleccionarPorPais(String pais) {

        TypedQuery<Mesa> query = this.entityManager.createQuery(
                "SELECT m FROM Mesa m WHERE m.paisOrigen = :datoPais",
                Mesa.class);

        query.setParameter("datoPais", pais);
        return query.getSingleResult();
    }

    @Override
    public List<Mesa> seleccionarListaPorMaterial(String material) {
        Query query = this.entityManager.createQuery(
                "SELECT m FROM Mesa m WHERE m.material = :datoMaterial");
        query.setParameter("datoMaterial", material);
        return query.getResultList();
    }

    @Override
    public List<Mesa> seleccionarListaPorPrecio(BigDecimal precio) {
        TypedQuery<Mesa> query = this.entityManager.createQuery(
                "SELECT m FROM Mesa m WHERE m.precio = :datoPrecio",
                Mesa.class);
        query.setParameter("datoPrecio",precio);
        return query.getResultList();
    }

}
