package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Boleto;

public interface IBoletoRepository {
    public void insertar(Boleto boleto);
    public void actulizar(Boleto boleto);
    public Boleto leer(Integer id);
    public void eliminarPorId(Integer id);

    public List<Boleto> leerInnerJoin();

    public List<Boleto> leerRightJoin();

    public List<Boleto> leerLeftJoin();

    public List<Boleto> leerFullJoin();

    public List<Boleto> leerJoinWhere();
    
    public List<Boleto> leerJoinFetch();
}
