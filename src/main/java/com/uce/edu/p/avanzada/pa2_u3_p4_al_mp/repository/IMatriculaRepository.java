package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Matricula;

public interface IMatriculaRepository {
    public void insertar(Matricula matricula);
    public List<Matricula> leerMatriculas();
}
