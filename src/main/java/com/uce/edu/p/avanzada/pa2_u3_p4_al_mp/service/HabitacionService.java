package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Habitacion;

public interface HabitacionService {
    public void agregar(Habitacion habitacion);
    public Habitacion buscarPorNumero(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Habitacion habitacion);
}
