package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Libro;

public interface LibroRepository {

    public void crear(Libro libro);
    public void actualizar(Libro libro);
    public void borrar(Integer id);
    public Libro leer(Integer id);

    
}
