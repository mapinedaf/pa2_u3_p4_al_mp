package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Empleado;

public interface EmpleadoRepository {

    public void insertar(Empleado empleado);

    public Empleado leer(Integer id);

    public void actualizar(Empleado empleado);

    public void borrar(Integer id);

}
