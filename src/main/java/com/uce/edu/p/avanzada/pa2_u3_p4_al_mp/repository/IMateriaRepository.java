package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;


import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Materia;

public interface IMateriaRepository {
    public Materia leerPorCodigo(String codigo);
}
