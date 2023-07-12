package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Empleado;

public interface EmpleadoService {
    public void agregar(Empleado empleado);

    public Empleado buscarPorId(Integer id);

    public void actualizarEmpleado(Empleado empleado);

    public void eliminarPorId(Integer id);
}
