package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.EstudianteDTO;

public interface EstudianteService {

    public void agregar(Estudiante estudiante);

    public Estudiante buscarPorCedula(String cedula);

    public void actualizarEstudiante(Estudiante estudiante);

    public void eliminarPorCedula(String cedula);

    public Estudiante buscarPorApellido(String apellido);

    public List<Estudiante> reportePorApellido(String apellido);

    public Estudiante buscarPorApellidoYNombre(String apellido, String nombre);

    public Estudiante buscarPorApellidoTyped(String apellido);

    public Estudiante busarPorApellidoNamed(String apellido);

    public Estudiante buscarPorApellidoNamedQuery(String apellido);

    public Estudiante buscarPorApellidoNativeQuery(String apellido);

    public Estudiante buscarPorApellidoNativeQueryNamed(String apellido);

    public Estudiante busarPorNombreNamed(String nombre);

    public Estudiante buscarPorNombreNativeQueryNamed(String nombre);

    public Estudiante buscarEstudianteDinamico(String nombre, String apellido, Double peso);

    public int eliminarPorNombre(String nombre);

    public int actualizarPorApellido(String nombrem, String apellido);

    public List<EstudianteDTO> buscarTodoDTO();
}
