package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.IHotelRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

    @Autowired
    private IHotelRepository hotelRepository;

    @Override
    public void agregar(Hotel Hotel) {
        this.hotelRepository.insertar(Hotel);
    }

    @Override
    public Hotel buscarPorNumero(Integer id) {
        return this.hotelRepository.seleccionarPorNumero(id);
    }

    @Override
    public void eliminar(Integer id) {
        this.hotelRepository.eliminar(id);
    }

    @Override
    public void actualizar(Hotel Hotel) {
        this.hotelRepository.actualizar(Hotel);
    }

    @Override
    public List<Hotel> buscarInnerJoin() {
       return this.hotelRepository.seleccionarInnerJoin();
    }

    @Override
    public List<Hotel> buscarRightOuterJoin() {
        return this.hotelRepository.seleccionarOuterRightJoin();
    }

    @Override
    public List<Hotel> buscarLeftOuterJoin() {

        return this.hotelRepository.seleccionarOuterLeftJoin();
    }

    @Override
    public List<Habitacion> buscarHabitacionLeftOuterJoin() {
        return this.hotelRepository.seleccionarHabitacionOuterLeftJoin();
    }

    @Override
    public List<Hotel> buscarOuterFullJoin() {
       return this.hotelRepository.seleccionarOuterFullJoin();
    }

    @Override
    public List<Hotel> buscarWhereJoin() {
        return this.hotelRepository.seleccionarWhereJoin();
    }
    
}
