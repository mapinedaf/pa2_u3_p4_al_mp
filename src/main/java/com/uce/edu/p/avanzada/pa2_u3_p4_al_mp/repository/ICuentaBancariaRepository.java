package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

    public void insertar(CuentaBancaria cuentaBancaria);
    
    public void actulizar(CuentaBancaria cuentaBancaria);
}
