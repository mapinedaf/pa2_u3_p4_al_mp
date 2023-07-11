package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.MesaRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Mesa;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    MesaRepository mRepository;

    @Override
    public void guardar(Mesa Mesa) {
        mRepository.insertar(Mesa);
    }

    @Override
    public Mesa buscarPorId(Integer id) {
        return mRepository.leer(id);
    }

    @Override
    public void actualizar(Mesa mesa) {
        mRepository.actualizar(mesa);
    }

    @Override
    public void borrarPorId(Integer id) {
        mRepository.borrar(id);
    }

    @Override
    public Mesa buscarPorFabricante(String fabricante) {
        return mRepository.seleccionarPorFabricante(fabricante); 
    }

    @Override
    public Mesa buscarPorPais(String pais) {
        return mRepository.seleccionarPorPais(pais);
    }

    @Override
    public List<Mesa> buscarListaPorMaterial(String material) {
        return mRepository.seleccionarListaPorMaterial(material);
    }

    @Override
    public List<Mesa> buscarListaPorPrecio(BigDecimal precio) {
        return mRepository.seleccionarListaPorPrecio(precio);
    }
    
}
