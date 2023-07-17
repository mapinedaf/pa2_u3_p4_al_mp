package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Vuelo;

public interface IVueloService {
    public void agregar(Vuelo vuelo);

    public void actulizar(Vuelo vuelo);

    public Vuelo buscar(Integer id);

    public void borrarPorId(Integer id);

    public List<Vuelo> buscarInnerJoin();

    public List<Vuelo> buscarRightJoin();

    public List<Vuelo> buscarLeftJoin();

    public List<Vuelo> buscarFullJoin();

    public List<Vuelo> buscarJoinWhere();

    public List<Vuelo> buscarJoinFetch();
}
