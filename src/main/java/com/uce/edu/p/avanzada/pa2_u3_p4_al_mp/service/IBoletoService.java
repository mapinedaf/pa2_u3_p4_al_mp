package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Boleto;

public interface IBoletoService {
    public void agregar(Boleto boleto);

    public void actulizar(Boleto boleto);

    public Boleto buscar(Integer id);

    public void borrarPorId(Integer id);

    public List<Boleto> buscarInnerJoin();

    public List<Boleto> buscarRightJoin();

    public List<Boleto> buscarLeftJoin();

    public List<Boleto> buscarFullJoin();

    public List<Boleto> buscarJoinWhere();

    public List<Boleto> buscarJoinFetch();
}