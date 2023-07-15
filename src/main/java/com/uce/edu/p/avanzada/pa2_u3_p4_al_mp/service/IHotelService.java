package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Hotel;

public interface IHotelService {
    public void agregar(Hotel hotel);

    public Hotel buscarPorNumero(Integer id);

    public void eliminar(Integer id);

    public void actualizar(Hotel hotel);

    public List<Hotel> buscarInnerJoin();

    public List<Hotel> buscarRightOuterJoin();

    public List<Hotel> buscarLeftOuterJoin();

    public List<Habitacion> buscarHabitacionLeftOuterJoin();

    public List<Hotel> buscarOuterFullJoin();

    public List<Hotel> buscarWhereJoin();

    public List<Hotel> buscarJoinFetch();
}
