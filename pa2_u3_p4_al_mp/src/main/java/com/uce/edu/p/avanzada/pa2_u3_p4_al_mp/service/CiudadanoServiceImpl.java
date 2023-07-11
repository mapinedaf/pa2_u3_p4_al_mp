package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.CiudadanoRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Ciudadano;

@Service
public class CiudadanoServiceImpl implements CiudadanoService {

    @Autowired
    private CiudadanoRepository ciudadanoRepository;

    @Override
    public void agregar(Ciudadano ciudadano) {
        ciudadanoRepository.insertar(ciudadano);
    }

    @Override
    public Ciudadano buscarPorId(Integer id) {
       return  ciudadanoRepository.leer(id);
    }

    @Override
    public void actualizarCiudadano(Ciudadano ciudadano) {
        ciudadanoRepository.actualizar(ciudadano);
    }

    @Override
    public void eliminarPorId(Integer id) {
        ciudadanoRepository.borrar(id);
    }
    
}
