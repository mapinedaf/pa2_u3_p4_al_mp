package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{
     @PersistenceContext 
    private EntityManager entityManager;

    @Override
    public void insertar(Hotel hotel) {
        this.entityManager.persist(hotel);
    }

    @Override
    public Hotel seleccionarPorNumero(Integer id) {

        Hotel hotel =  this.entityManager.find(Hotel.class, id);

        //hotel.getHabitaciones().get(0).getNumero();

        System.out.println("Cantidad de habitaciones: "+hotel.getHabitaciones().size());

        return hotel;
    }

    @Override
    public void eliminar(Integer id) {
        Hotel hotel = this.seleccionarPorNumero(id);
        this.entityManager.remove(hotel);
        
    }

    @Override
    public void actualizar(Hotel hotel) {
        this.entityManager.merge(hotel);
    }

    @Override
    public List<Hotel> seleccionarInnerJoin() {

        String jpql ="SELECT h FROM Hotel h JOIN h.habitaciones ha";

        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);

        List<Hotel> list = myQuery.getResultList();

        list.stream().forEach(x -> x.getHabitaciones().size());

       return list;
    }

    @Override
    public List<Hotel> seleccionarOuterRightJoin() {
        String jpql ="SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha";

        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);

    

       return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarOuterLeftJoin() {
        String jpql ="SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha";

        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);

    

       return myQuery.getResultList();
    }

    @Override
    public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
        String jpql ="SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha";

        TypedQuery <Habitacion> myQuery  = this.entityManager.createQuery(jpql,Habitacion.class);

    

       return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarOuterFullJoin() {
 String jpql ="SELECT h FROM Hotel h FULL JOIN h.habitaciones ha";

        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);

    

       return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarWhereJoin() {
        //Comparar dos objetos 1 a 1 
        String jpql ="SELECT h FROM Hotel h, Habitacion ha WHERE h=ha.hotel" ;

        
        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);

    

       return myQuery.getResultList();
    }

    @Override
    public List<Hotel> seleccionarFetchJoin() {
        String jpql ="SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha";

        TypedQuery <Hotel> myQuery  = this.entityManager.createQuery(jpql,Hotel.class);

        List<Hotel> list = myQuery.getResultList();


       return list;
    }
    
}
