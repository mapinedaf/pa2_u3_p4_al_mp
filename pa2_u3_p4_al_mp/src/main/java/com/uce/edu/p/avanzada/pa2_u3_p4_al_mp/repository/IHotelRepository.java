package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Hotel;

public interface IHotelRepository {
    
    public void insertar(Hotel hotel);
    public Hotel seleccionarPorNumero(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Hotel hotel);

    public List<Hotel> seleccionarInnerJoin();

}
