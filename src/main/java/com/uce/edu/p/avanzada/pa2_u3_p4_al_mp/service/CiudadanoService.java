package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Ciudadano;

public interface CiudadanoService {
        public void agregar(Ciudadano ciudadano);

    public Ciudadano buscarPorId(Integer id);

    public void actualizarCiudadano(Ciudadano ciudadano);

    public void eliminarPorId(Integer id);
}
