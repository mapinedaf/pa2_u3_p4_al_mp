package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Vuelo;

public interface IVueloRepository {
    public void insertar(Vuelo vuelo);

    public void actulizar(Vuelo vuelo);

    public Vuelo leer(Integer id);

    public void eliminarPorId(Integer id);

    public List<Vuelo> leerInnerJoin();

    public List<Vuelo> leerRightJoin();

    public List<Vuelo> leerLeftJoin();

    public List<Vuelo> leerFullJoin();

    public List<Vuelo> leerJoinWhere();

    public List<Vuelo> leerJoinFetch();
}