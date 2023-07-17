package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.IVueloRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Vuelo;

@Service
public class VueloServiceImpl implements IVueloService{

    @Autowired
    IVueloRepository vueloRepository;

    @Override
    public void agregar(Vuelo vuelo) {
        this.vueloRepository.insertar(vuelo);
    }

    @Override
    public void actulizar(Vuelo vuelo) {
        this.vueloRepository.actulizar(vuelo);
    }

    @Override
    public Vuelo buscar(Integer id) {
        return this.vueloRepository.leer(id);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.vueloRepository.eliminarPorId(id);
    }

    @Override
    public List<Vuelo> buscarInnerJoin() {
        return this.vueloRepository.leerInnerJoin();
    }

    @Override
    public List<Vuelo> buscarRightJoin() {
        return this.vueloRepository.leerRightJoin();
    }

    @Override
    public List<Vuelo> buscarLeftJoin() {
        return this.vueloRepository.leerLeftJoin();
    }

    @Override
    public List<Vuelo> buscarFullJoin() {
       return this.vueloRepository.leerFullJoin();
    }

    @Override
    public List<Vuelo> buscarJoinWhere() {
        return this.vueloRepository.leerJoinWhere();
    }

    @Override
    public List<Vuelo> buscarJoinFetch() {
        return this.vueloRepository.leerJoinFetch();
    }
    
}
