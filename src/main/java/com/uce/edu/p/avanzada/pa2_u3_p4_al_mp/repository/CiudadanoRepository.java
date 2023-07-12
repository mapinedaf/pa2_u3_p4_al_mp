package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Ciudadano;

public interface CiudadanoRepository {
    public void insertar(Ciudadano ciudadano);

    public Ciudadano leer(Integer id);

    public void actualizar(Ciudadano ciudadano);

    public void borrar(Integer id);
}
