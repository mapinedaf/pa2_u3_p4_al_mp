package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.IBoletoRepository;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Boleto;
@Service
public class BoletoServiceImpl implements IBoletoService{

    @Autowired
    IBoletoRepository boletoRepository;

    @Override
    public void agregar(Boleto boleto) {
        this.boletoRepository.insertar(boleto);
    }

    @Override
    public void actulizar(Boleto boleto) {
        this.boletoRepository.actulizar(boleto);
    }

    @Override
    public Boleto buscar(Integer id) {
       return  this.boletoRepository.leer(id);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.boletoRepository.eliminarPorId(id);
    }

    @Override
    public List<Boleto> buscarInnerJoin() {
        return this.boletoRepository.leerInnerJoin();
    }

    @Override
    public List<Boleto> buscarRightJoin() {
        return this.boletoRepository.leerRightJoin();
    }

    @Override
    public List<Boleto> buscarLeftJoin() {
        return this.boletoRepository.leerLeftJoin();
    }

    @Override
    public List<Boleto> buscarFullJoin() {
        return this.boletoRepository.leerFullJoin();
    }

    @Override
    public List<Boleto> buscarJoinWhere() {
        return this.boletoRepository.leerJoinWhere();
    }

    @Override
    public List<Boleto> buscarJoinFetch() {
        return this.boletoRepository.leerJoinFetch();
    }
    
}
