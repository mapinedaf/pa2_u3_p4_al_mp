package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import java.util.List;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Hotel;

public interface IHotelRepository {

    public void insertar(Hotel hotel);

    public Hotel seleccionarPorNumero(Integer id);

    public void eliminar(Integer id);

    public void actualizar(Hotel hotel);

    public List<Hotel> seleccionarInnerJoin();

    public List<Hotel> seleccionarOuterRightJoin();

    public List<Hotel> seleccionarOuterLeftJoin();

    public List<Habitacion> seleccionarHabitacionOuterLeftJoin();

    public List<Hotel> seleccionarOuterFullJoin();

     public List<Hotel> seleccionarWhereJoin();

     public List<Hotel> seleccionarFetchJoin();
     
}
