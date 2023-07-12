package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Libro;

public interface LibroService {

    public void agregar(Libro libro);

    public Libro buscarPorId(Integer id);

    public void actualizarLibro(Libro libro);

    public void eliminarPorId(Integer id);
}
