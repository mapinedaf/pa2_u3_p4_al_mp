package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.EmpleadoRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public void agregar(Empleado empleado) {
        empleadoRepository.insertar(empleado);
    }

    @Override
    public Empleado buscarPorId(Integer id) {
       return  empleadoRepository.leer(id);
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        empleadoRepository.actualizar(empleado);
    }

    @Override
    public void eliminarPorId(Integer id) {
        empleadoRepository.borrar(id);
    }
}
