package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.IEstudianteRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.IMateriaRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.IMatriculaRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Materia;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    IMatriculaRepository matriculaRepository;

    @Autowired
    IEstudianteRepository estudianteRepository;

    @Autowired
    IMateriaRepository materiaRepository;

    private static int numero = 0;

    @Override
    public void generarMatricula(String cedulaEstudiante, String[] codigosMaterias) {

        Estudiante estudiante = this.estudianteRepository.leerPorCedula(cedulaEstudiante);

        List<Materia> materias = new ArrayList();

        for (String codigo : codigosMaterias) {
            materias.add(materiaRepository.leerPorCodigo(codigo));
        }

        for (Materia m : materias) {
            numero = numero + 1;

            Matricula matricula = Matricula.builder()
                    .numero(numero + "")
                    .fecha(LocalDate.now())
                    .hora(LocalTime.now())
                    .estudiante(estudiante)
                    .materia(m)
                    .build();

            estudiante.getMatriculas().add(matricula);
            m.getMatriculas().add( matricula);        
            this.matriculaRepository.insertar(matricula);
        }

    }

    @Override
    public List<Matricula> reporteMatriculas() {
        return this.matriculaRepository.leerMatriculas();
    }

}
