package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.IHotelRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

    @Autowired
    private IHotelRepository HotelRepository;

    @Override
    public void agregar(Hotel Hotel) {
        this.HotelRepository.insertar(Hotel);
    }

    @Override
    public Hotel buscarPorNumero(Integer id) {
        return this.HotelRepository.seleccionarPorNumero(id);
    }

    @Override
    public void eliminar(Integer id) {
        this.HotelRepository.eliminar(id);
    }

    @Override
    public void actualizar(Hotel Hotel) {
        this.HotelRepository.actualizar(Hotel);
    }

    @Override
    public List<Hotel> buscarInnerJoin() {
       return this.HotelRepository.seleccionarInnerJoin();
    }
    
}
