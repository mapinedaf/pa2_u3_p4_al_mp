package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Mesa;


public interface MesaRepository {

    public void insertar(Mesa Mesa);

    public Mesa leer(Integer id);

    public void actualizar(Mesa mesa);

    public void borrar(Integer id);


    //query
    public Mesa seleccionarPorFabricante(String fabricante);

    //typed query
    public Mesa seleccionarPorPais(String pais);


    //query
    public List<Mesa> seleccionarListaPorMaterial(String material);

    //typed query
    public List<Mesa> seleccionarListaPorPrecio(BigDecimal precio);
}
