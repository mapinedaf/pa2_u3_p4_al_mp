package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.EstudianteRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.EstudianteDTO;

@Service 
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public void agregar(Estudiante estudiante) {
        this.estudianteRepository.insertar(estudiante);
    }

    @Override
    public Estudiante buscarPorCedula(String cedula) {
       return this.estudianteRepository.leer(cedula);
    }

    @Override
    public void actualizarEstudiante(Estudiante estudiante) {
        this.estudianteRepository.actualizar(estudiante);
    }

    @Override
    public void eliminarPorCedula(String cedula) {
        this.estudianteRepository.borrar(cedula);
    }

    @Override
    public Estudiante buscarPorApellido(String apellido) {
        return this.estudianteRepository.seleccionarPorApellido(apellido);
    }

    @Override
    public List<Estudiante> reportePorApellido(String apellido) {
        return this.estudianteRepository.seleccionarListaPorApellido(apellido);
    }

    @Override
    public Estudiante buscarPorApellidoYNombre(String apellido, String nombre) {
       return this.estudianteRepository.seleccionarPorApellidoYNombew(apellido, nombre);
    }

    @Override
    public Estudiante buscarPorApellidoTyped(String apellido) {
        return this.estudianteRepository.seeleccionarPorApellidoTyped(apellido);
    }

    @Override
    public Estudiante busarPorApellidoNamed(String apellido) {
        return this.estudianteRepository.seeleccionarPorApellidoNamed(apellido);
    }

    @Override
    public Estudiante buscarPorApellidoNamedQuery(String apellido) {
        return this.estudianteRepository.seleccionarPorApellidoNamedQuery(apellido);
    }

    @Override
    public Estudiante buscarPorApellidoNativeQuery(String apellido) {
        return this.estudianteRepository.seleccionarPorApellidoNativeQuery(apellido);
    }

    @Override
    public Estudiante buscarPorApellidoNativeQueryNamed(String apellido) {
       return this.estudianteRepository.seleccionarPorApellidoNativeQueryNamed(apellido);

    }

    @Override
    public Estudiante busarPorNombreNamed(String nombre) {
       return this.estudianteRepository.seeleccionarPorNombreNamed(nombre);
    }

    @Override
    public Estudiante buscarPorNombreNativeQueryNamed(String nombre) {
       return this.estudianteRepository.seleccionarPorNombreNativeQueryNamed(nombre);
    }

    @Override
    public Estudiante buscarEstudianteDinamico(String nombre, String apellido, Double peso) {
        return this.estudianteRepository.seleccionarEstudianteDinamico(nombre, apellido, peso);
    }

    @Override
    public int eliminarPorNombre(String nombre) {
       return this.estudianteRepository.eliminarPorNombre(nombre);
    }

    @Override
    public int actualizarPorApellido(String nombrem, String apellido) {
       return this.estudianteRepository.actualizarPorApellido(nombrem, apellido);
    }

    @Override
    public List<EstudianteDTO> buscarTodoDTO() {
        return this.estudianteRepository.seleccionarTodosDTO();
    }

    
}
