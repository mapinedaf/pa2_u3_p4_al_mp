package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;



import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    public Estudiante leerPorCedula(String cedula);
}
