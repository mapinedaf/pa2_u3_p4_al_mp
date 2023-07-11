package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.SitioDeInteres;

public interface SitioDeInteresService {
        public void registrarSitio(SitioDeInteres sitioDeInteres);

    public SitioDeInteres buscarSitioPorId(Integer id);

    public void actualizarSitio(SitioDeInteres sitioDeInteres);

    public void borrarSitio(SitioDeInteres sitioDeInteres);

    public List<SitioDeInteres> reporteSitiosRecomendados();
        public int  actualizarHorarios(LocalTime horaAperturaOld, LocalTime horaAperturaNew );

    public int borrarPorCategoria( String categoria);
}
