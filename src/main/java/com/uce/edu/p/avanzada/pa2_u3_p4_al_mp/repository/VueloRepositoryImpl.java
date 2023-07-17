package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Vuelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public void insertar(Vuelo vuelo) {
        this.entityManager.persist(vuelo);
    }

    @Override
    public void actulizar(Vuelo vuelo) {
        this.entityManager.merge(vuelo);
    }

    @Override
    public Vuelo leer(Integer id) {
        return this.entityManager.find(Vuelo.class, id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        this.entityManager.remove(leer(id));
    }

    @Override
    public List<Vuelo> leerInnerJoin() {
        String jpql = "SELECT v FROM Vuelo v JOIN v.boletos bo";

        TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(jpql, Vuelo.class);

        List<Vuelo> list = myQuery.getResultList();

        list.stream().forEach(x -> x.getBoletos().size());

        return list;
    }

    @Override
    public List<Vuelo> leerRightJoin() {
        String jpql = "SELECT v FROM Vuelo v RIGHT JOIN v.boletos bo";

        TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(jpql, Vuelo.class);

        List<Vuelo> list = myQuery.getResultList();

        list.stream().forEach(x -> x.getBoletos().size());

        return list;
    }

    @Override
    public List<Vuelo> leerLeftJoin() {
        String jpql = "SELECT v FROM Vuelo v LEFT JOIN v.boletos bo";

        TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(jpql, Vuelo.class);

        List<Vuelo> list = myQuery.getResultList();

        list.stream().forEach(x -> x.getBoletos().size());

        return list;
    }

    @Override
    public List<Vuelo> leerFullJoin() {
        String jpql = "SELECT v FROM Vuelo v FULL JOIN v.boletos bo";

        TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(jpql, Vuelo.class);

        List<Vuelo> list = myQuery.getResultList();

        list.stream().forEach(x -> x.getBoletos().size());

        return list;
    }

    @Override
    public List<Vuelo> leerJoinWhere() {
        String jpql = "SELECT v FROM Vuelo v, Boleto b WHERE v=b.vuelo";

        TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(jpql, Vuelo.class);

        List<Vuelo> list = myQuery.getResultList();

        list.stream().forEach(x -> x.getBoletos().size());

        return list;
    }

    @Override
    public List<Vuelo> leerJoinFetch() {
        String jpql = "SELECT v FROM Vuelo v  JOIN FETCH v.boletos bo";

        TypedQuery <Vuelo> myQuery  = this.entityManager.createQuery(jpql,Vuelo.class);

        List<Vuelo> list = myQuery.getResultList();


       return list;
    }

}
