package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Libro;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Matricula;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.MatriculaDTO;

public interface MatriculaService {
    public void agregar(Matricula matricula);

    public Matricula buscarPorId(Integer id);

    public void actualizarMatricula(Matricula matricula);

    public void eliminarPorId(Integer id);

    public List<MatriculaDTO> buscarTodosDTO();
}
