package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Boleto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BoletoRepositoryImpl implements IBoletoRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public void insertar(Boleto boleto) {
        this.entityManager.persist(boleto);
    }

    @Override
    public void actulizar(Boleto boleto) {
        this.entityManager.merge(boleto);
    }

    @Override
    public Boleto leer(Integer id) {
        return this.entityManager.find(Boleto.class, id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        this.entityManager.remove(leer(id));
    }

    @Override
    public List<Boleto> leerInnerJoin() {
        String jpql = "SELECT b FROM Boleto b JOIN b.vuelo v";

        TypedQuery<Boleto> myQuery = this.entityManager.createQuery(jpql, Boleto.class);

        List<Boleto> list = myQuery.getResultList();

        list.stream().forEach(x -> x.getVuelo());

        return list;
    }

    @Override
    public List<Boleto> leerRightJoin() {
        String jpql = "SELECT b FROM Boleto b RIGHT JOIN b.vuelo v";

        TypedQuery<Boleto> myQuery = this.entityManager.createQuery(jpql, Boleto.class);

        List<Boleto> list = myQuery.getResultList();

        try {
            list.stream().forEach(x -> x.getVuelo());
        } catch (Exception e) {
        }

        return list;
    }

    @Override
    public List<Boleto> leerLeftJoin() {
        String jpql = "SELECT b FROM Boleto b LEFT JOIN b.vuelo v";

        TypedQuery<Boleto> myQuery = this.entityManager.createQuery(jpql, Boleto.class);

        List<Boleto> list = myQuery.getResultList();

        try {
            list.stream().forEach(x -> x.getVuelo());
        } catch (Exception e) {
        }

        return list;
    }

    @Override
    public List<Boleto> leerFullJoin() {
        String jpql = "SELECT b FROM Boleto b FULL JOIN b.vuelo v";

        TypedQuery<Boleto> myQuery = this.entityManager.createQuery(jpql, Boleto.class);

        List<Boleto> list = myQuery.getResultList();

        try {
            list.stream().forEach(x -> x.getVuelo());
        } catch (Exception e) {
        }

        return list;
    }

    @Override
    public List<Boleto> leerJoinWhere() {
        String jpql = "SELECT b FROM Boleto b, Vuelo v WHERE v=b.vuelo";

        TypedQuery<Boleto> myQuery = this.entityManager.createQuery(jpql, Boleto.class);

        List<Boleto> list = myQuery.getResultList();

        try {
            list.stream().forEach(x -> x.getVuelo());
        } catch (Exception e) {
        }

        return list;
    }

    @Override
    public List<Boleto> leerJoinFetch() {
        String jpql = "SELECT b FROM Boleto b  JOIN FETCH b.vuelo v";

        TypedQuery<Boleto> myQuery = this.entityManager.createQuery(jpql, Boleto.class);

        List<Boleto> list = myQuery.getResultList();

        return list;
    }
}
