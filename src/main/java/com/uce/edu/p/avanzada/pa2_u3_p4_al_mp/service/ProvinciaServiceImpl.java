package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.IProvinciaRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Provincia;
@Service
public class ProvinciaServiceImpl  implements IProvinciaService{

    @Autowired
    IProvinciaRepository provinciaRepository;

    @Override
    public void guardar(Provincia provincia) {
        this.provinciaRepository.insertar(provincia);
    }
    
}
