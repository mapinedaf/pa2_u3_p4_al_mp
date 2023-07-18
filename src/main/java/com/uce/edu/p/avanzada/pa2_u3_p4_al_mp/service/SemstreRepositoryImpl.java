package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.ISemestreRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Semestre;

import jakarta.persistence.EntityManager;

@Service
public class SemstreRepositoryImpl implements ISemetreService{
    @Autowired
    ISemestreRepository semestreRepository;

    @Override
    public void guardar(Semestre semestre) {
        this.semestreRepository.insertar(semestre);
    }

}
