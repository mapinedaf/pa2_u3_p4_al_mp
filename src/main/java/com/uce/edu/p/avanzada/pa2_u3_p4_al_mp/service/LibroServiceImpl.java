package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.LibroRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Libro;


@Service
public class LibroServiceImpl  implements LibroService{

    @Autowired
    private LibroRepository empleadoRepository;

    @Override
    public void agregar(Libro empleado) {
        empleadoRepository.crear(empleado);
    }

    @Override
    public Libro buscarPorId(Integer id) {
       return  empleadoRepository.leer(id);
    }

    @Override
    public void actualizarLibro(Libro empleado) {
        empleadoRepository.actualizar(empleado);
    }

    @Override
    public void eliminarPorId(Integer id) {
        empleadoRepository.borrar(id);
    }
    
}
