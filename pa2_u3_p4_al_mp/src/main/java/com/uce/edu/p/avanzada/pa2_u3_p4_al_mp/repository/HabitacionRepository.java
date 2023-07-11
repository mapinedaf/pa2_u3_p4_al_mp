package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Habitacion;

public interface HabitacionRepository {

    public void insertar(Habitacion habitacion);
    public Habitacion seleccionarPorNumero(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Habitacion habitacion);
    
}
