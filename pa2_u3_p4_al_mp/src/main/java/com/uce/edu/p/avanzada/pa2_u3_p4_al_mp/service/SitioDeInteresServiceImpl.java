package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.SitioDeInteresRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.SitioDeInteres;

@Service
public class SitioDeInteresServiceImpl implements SitioDeInteresService {

    @Autowired
    SitioDeInteresRepository sitioDeInteresRepository;

    @Override
    public void registrarSitio(SitioDeInteres sitioDeInteres) {
        this.sitioDeInteresRepository.insertar(sitioDeInteres);
    }

    @Override
    public SitioDeInteres buscarSitioPorId(Integer id) {
        return this.sitioDeInteresRepository.leer(id);
    }

    @Override
    public void actualizarSitio(SitioDeInteres sitioDeInteres) {
        this.sitioDeInteresRepository.actualizar(sitioDeInteres);
    }

    @Override
    public void borrarSitio(SitioDeInteres sitioDeInteres) {
        this.sitioDeInteresRepository.borrar(sitioDeInteres);
    }

    @Override
    public List<SitioDeInteres> reporteSitiosRecomendados() {
        double calificacion = 4.5;

        boolean estaLluviendo = new Random().nextBoolean(); //mock api clima 

        return this.sitioDeInteresRepository.leerRecomendados(calificacion, estaLluviendo);
    }

    @Override
    public int actualizarHorarios(LocalTime horaAperturaOld, LocalTime horaAperturaNew) {
        return this.sitioDeInteresRepository.actualizarHorarios(horaAperturaOld,horaAperturaNew);
    }

    @Override
    public int borrarPorCategoria(String categoria) {
        return this.sitioDeInteresRepository.borrarPorCategoria(categoria);
    }



    
}
