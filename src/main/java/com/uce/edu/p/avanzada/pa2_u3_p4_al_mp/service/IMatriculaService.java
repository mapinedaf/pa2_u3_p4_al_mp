package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Matricula;

public interface IMatriculaService {

    public void generarMatricula(String cedulaEstudiante,String[] codigosMaterias);
    
    public List<Matricula> reporteMatriculas();
}
