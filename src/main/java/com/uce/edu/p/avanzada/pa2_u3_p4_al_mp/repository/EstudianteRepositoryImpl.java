package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Estudiante estudiante) {

        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {

        this.entityManager.merge(estudiante);

    }

    @Override
    public void borrar(String cedula) {

        this.entityManager.remove(leer(cedula));

    }

    @Override
    public Estudiante leer(String edula) {

        return this.entityManager.find(Estudiante.class, edula);
    }

    @Override
    public Estudiante seleccionarPorApellido(String apellido) {
        // sql
        // SELECT * FROM estudiante e WHERE estu_apellido =

        // JPQL
        // SELECT e FROM Estudiante e WHERE e.apellido = variable vv
        Query query = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
        query.setParameter("datoApellido", apellido);
        return (Estudiante) query.getSingleResult(); // casteo
    }

    @Override
    public Estudiante seleccionarPorApellidoYNombew(String apellido, String nombre) {
        Query query = this.entityManager
                .createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido AND e.nombre = :datoNombre");
        query.setParameter("datoApellido", apellido);
        query.setParameter("datoNombre", nombre);
        return (Estudiante) query.getSingleResult();

    }

    @Override
    public List<Estudiante> seleccionarListaPorApellido(String apellido) {
        Query query = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido");
        query.setParameter("datoApellido", apellido);
        return query.getResultList();
    }

    @Override
    public Estudiante seeleccionarPorApellidoTyped(String apellido) {

        TypedQuery<Estudiante> query = this.entityManager.createQuery(
                "SELECT e FROM Estudiante e WHERE e.apellido = :datoApellido",
                Estudiante.class);

        query.setParameter("datoApellido", apellido);
        return query.getSingleResult();
    }

    @Override
    public Estudiante seeleccionarPorApellidoNamed(String apellido) {

        TypedQuery<Estudiante> query = this.entityManager
                .createNamedQuery("Estudiante.buscaPorApellido", Estudiante.class);

        query.setParameter("datoApellido", apellido);
        return query.getSingleResult();
    }

    @Override
    public Estudiante seleccionarPorApellidoNamedQuery(String apellido) {
        Query query = this.entityManager
                .createNamedQuery("Estudiante.buscaPorApellido", Estudiante.class);

        query.setParameter("datoApellido", apellido);
        return (Estudiante) query.getSingleResult();
    }

    @Override
    public Estudiante seleccionarPorApellidoNativeQuery(String apellido) {

        String sql = "SELECT * FROM estudiante WHERE estu_apellido = :datoApellido";

        Query query = this.entityManager.createNativeQuery(sql, Estudiante.class);

        query.setParameter("datoApellido", apellido);

        return (Estudiante) query.getSingleResult();
    }

    @Override
    public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido) {
        TypedQuery<Estudiante> query = this.entityManager.createNamedQuery("Estudiante.buscarApellidoNative",
                Estudiante.class);
        query.setParameter("datoApellido", apellido);
        return query.getSingleResult();
    }

    @Override
    public Estudiante seeleccionarPorNombreNamed(String nombre) {
        TypedQuery<Estudiante> query = this.entityManager
                .createNamedQuery("Estudiante.buscaPorNombre", Estudiante.class);

        query.setParameter("datoNombre", nombre);
        return query.getSingleResult();
    }

    @Override
    public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre) {
        TypedQuery<Estudiante> query = this.entityManager.createNamedQuery("Estudiante.buscarNombreNative",
                Estudiante.class);
        query.setParameter("datoNombre", nombre);
        return query.getSingleResult();
    }

    @Override
    public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido) {

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        // Paso 1 especificar el tipo de retorno de la query
        CriteriaQuery<Estudiante> query = builder.createQuery(Estudiante.class);

        // Paso 2 empesamos a crear el sql
        // Definimos el from (root en criteria api query)
        Root<Estudiante> miTablaFrom = query.from(Estudiante.class);

        // Construit las condiciones del sql WHERE (Predicates een criteria api query)

        Predicate condicionApelido = builder.equal(miTablaFrom.get("apellido"), apellido);

        

        // Paso 4 Armar el sql
        query.select(miTablaFrom).where(condicionApelido);

        // Ejecucion del query con typed query
        TypedQuery<Estudiante> finalQuery = this.entityManager.createQuery(query);
        return finalQuery.getSingleResult();
    }

    @Override
    public Estudiante seleccionarEstudianteDinamico(String nombre, String apellido, Double peso) {

        // delarar un builder

        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

        CriteriaQuery<Estudiante> query = builder.createQuery(Estudiante.class);

        Root<Estudiante> miTablaFrom = query.from(Estudiante.class);

        // > 100 e.nombre = :dato AND e.apellido = :dato2
        // <= 100 e.nombre = :dato OR e.apellido = :dato2

        Predicate pNombre = builder.equal(miTablaFrom.get("nombre"), nombre);

        Predicate pApellido = builder.equal(miTablaFrom.get("apellido"), apellido);

        Predicate predicateFinal = peso.compareTo(Double.valueOf(100)) > 0 ? builder.and(pNombre, pApellido)
                : builder.or(pApellido, pNombre);

        query.select(miTablaFrom).where(predicateFinal);

        // Ejecucion del query con typed query
        TypedQuery<Estudiante> finalQuery = this.entityManager.createQuery(query);
        return finalQuery.getSingleResult();
    }

    @Override
    public int eliminarPorNombre(String nombre) {
        // DELETE FROM estudiante where estu_nombre = ?
        // Delete from Estudiante e where e.nombre = :datoNombre

        Query query = this.entityManager.createQuery("DELETE FROM Estudiante e WHERE e.nombre = :datoNombre");

        query.setParameter("datoNombre", nombre);

        return query.executeUpdate();
    }

    @Override
    public int actualizarPorApellido(String nombre, String apellido) {
        // sql
        // UPDATE estudiante SET estu_nombre = ? WHERE estu_apellido = ?

        // jpql
        // UPDATE Estudiante e SET e.nombre = :datoNombre WHERE e.apellido =
        // :datoApellido
        Query query = this.entityManager
                .createQuery("UPDATE Estudiante e SET e.nombre = :datoNombre WHERE e.apellido = :datoApellido");

        query.setParameter("datoApellido", apellido);
        query.setParameter("datoNombre", nombre);

        return query.executeUpdate();
    }

    @Override
    public List<EstudianteDTO> seleccionarTodosDTO() {

        String jpql = "SELECT NEW com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.EstudianteDTO(e.nombre,e.apellido) FROM Estudiante e ";
        TypedQuery<EstudianteDTO> query = this.entityManager.createQuery(jpql, EstudianteDTO.class);
        return query.getResultList();

    }

}
