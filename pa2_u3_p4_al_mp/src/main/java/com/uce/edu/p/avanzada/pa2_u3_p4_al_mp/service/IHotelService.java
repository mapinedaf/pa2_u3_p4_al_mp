package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Hotel;

public interface IHotelService {
    public void agregar(Hotel hotel);
    public Hotel buscarPorNumero(Integer id);
    public void eliminar(Integer id);
    public void actualizar(Hotel hotel);
        public List<Hotel> buscarInnerJoin();
}
