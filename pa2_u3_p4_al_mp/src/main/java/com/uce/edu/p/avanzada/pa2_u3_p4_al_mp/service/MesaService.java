package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Mesa;

public interface MesaService {
    public void guardar(Mesa Mesa);

    public Mesa buscarPorId(Integer id);

    public void actualizar(Mesa mesa);

    public void borrarPorId(Integer id);


    //query
    public Mesa buscarPorFabricante(String fabricante);

    public Mesa buscarPorPais(String pais);


    //typed query
    public List<Mesa> buscarListaPorMaterial(String material);

    public List<Mesa> buscarListaPorPrecio(BigDecimal precio);
}
