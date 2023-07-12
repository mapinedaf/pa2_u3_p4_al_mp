package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto.EstudianteDTO;

public interface EstudianteRepository {

    public void insertar(Estudiante estudiante);

    public Estudiante leer(String edula);

    public void actualizar(Estudiante estudiante);

    public void borrar(String cedula);

    public Estudiante seleccionarPorApellido(String apellido);

    public List<Estudiante> seleccionarListaPorApellido(String apellido);

    public Estudiante seleccionarPorApellidoYNombew(String apellido, String nombre);

    public Estudiante seeleccionarPorApellidoTyped(String apellido);

    public Estudiante seeleccionarPorApellidoNamed(String apellido);

    public Estudiante seleccionarPorApellidoNamedQuery(String apellido);

    public Estudiante seleccionarPorApellidoNativeQuery(String apellido);

    public Estudiante seleccionarPorApellidoNativeQueryNamed(String apellido);

    public Estudiante seeleccionarPorNombreNamed(String nombre);

    public Estudiante seleccionarPorNombreNativeQueryNamed(String nombre);

    public Estudiante seleccionarPorApellidoCriteriaAPIQuery(String apellido);

    public Estudiante seleccionarEstudianteDinamico(String nombre, String apellido, Double peso);


    public int eliminarPorNombre(String nombre);

    public int actualizarPorApellido(String nombrem, String apellido);

    public List<EstudianteDTO> seleccionarTodosDTO();
}
