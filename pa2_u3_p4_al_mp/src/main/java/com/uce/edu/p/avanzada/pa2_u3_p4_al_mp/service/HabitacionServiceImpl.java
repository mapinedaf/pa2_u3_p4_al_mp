package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.HabitacionRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
@Service
public class HabitacionServiceImpl implements HabitacionService{
     @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public void agregar(Habitacion habitacion) {
        this.habitacionRepository.insertar(habitacion);
    }

    @Override
    public Habitacion buscarPorNumero(Integer id) {
        return this.habitacionRepository.seleccionarPorNumero(id);
    }

    @Override
    public void eliminar(Integer id) {
        this.habitacionRepository.eliminar(id);
    }

    @Override
    public void actualizar(Habitacion Habitacion) {
        this.habitacionRepository.actualizar(Habitacion);
    }
    
}
