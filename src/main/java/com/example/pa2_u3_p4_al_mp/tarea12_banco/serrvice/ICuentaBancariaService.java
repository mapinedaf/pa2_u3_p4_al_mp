package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import java.util.concurrent.CompletableFuture;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
    public String agregar(CuentaBancaria cuentaBancaria);

    public void agregarAsincrono(CuentaBancaria cuentaBancaria);

    public CompletableFuture <String> agregarAsincrono2(CuentaBancaria cuentaBancaria);

    public void actulizar(CuentaBancaria cuentaBancaria);

    public void remover(String id);

    public CuentaBancaria buscarPorId(String id);

    public CuentaBancaria buscarPorNumCuentaBancaria(String id);
}
