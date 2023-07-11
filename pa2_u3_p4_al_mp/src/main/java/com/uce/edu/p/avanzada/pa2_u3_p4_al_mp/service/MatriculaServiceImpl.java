package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.MatriculaRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Matricula;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.MatriculaDTO;

@Service
public class MatriculaServiceImpl  implements MatriculaService{

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public void agregar(Matricula matricula) {
        matriculaRepository.crear(matricula);
    }

    @Override
    public Matricula buscarPorId(Integer id) {
       return  matriculaRepository.leer(id);
    }

    @Override
    public void actualizarMatricula(Matricula matricula) {
        matriculaRepository.actualizar(matricula);
    }

    @Override
    public void eliminarPorId(Integer id) {
        matriculaRepository.borrar(id);
    }

    @Override
    public List<MatriculaDTO> buscarTodosDTO() {
        return this.matriculaRepository.seleccionarTodos();
    }
    
}