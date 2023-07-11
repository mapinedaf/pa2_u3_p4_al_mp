package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Matricula;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.MatriculaDTO;

public interface MatriculaRepository {
    public void crear(Matricula matricula);
    public void actualizar(Matricula matricula);
    public void borrar(Integer id);
    public Matricula leer(Integer id);

    public List<MatriculaDTO> seleccionarTodos();

}
