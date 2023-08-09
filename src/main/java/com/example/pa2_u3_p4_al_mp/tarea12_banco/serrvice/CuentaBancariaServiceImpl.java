package com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.ICuentaBancariaRepository;
import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

    private final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);
    @Autowired
    private ICuentaBancariaRepository cuentaBancariaRepository;

    @Override
    public String agregar(CuentaBancaria cuentaBancaria) {

        try {
            TimeUnit.SECONDS.sleep(1);
            LOG.info(Thread.currentThread().getName());
            LOG.info("Se inserto la cuenta: " + cuentaBancaria.getNumero());
            this.cuentaBancariaRepository.insertar(cuentaBancaria);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return cuentaBancaria.getNumero();
    }

    @Override
    public void actulizar(CuentaBancaria cuentaBancaria) {
        this.cuentaBancariaRepository.actulizar(cuentaBancaria);
    }

    @Override
    public void remover(String id) {
        this.cuentaBancariaRepository.eliminar(id);
    }

    @Override
    public CuentaBancaria buscarPorId(String id) {
        return this.cuentaBancariaRepository.seleccionarPorId(id);
    }

    @Override
    public CuentaBancaria buscarPorNumCuentaBancaria(String id) {
        return this.cuentaBancariaRepository.seleccionarPorNumero(id);
    }

    @Override
    @Async
    public void agregarAsincrono(CuentaBancaria cuentaBancaria) {

        try {
            TimeUnit.SECONDS.sleep(1);
            LOG.info(Thread.currentThread().getName());
            LOG.info("Se inserto la cuenta: " + cuentaBancaria.getNumero());
            this.cuentaBancariaRepository.insertar(cuentaBancaria);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    @Async
    public CompletableFuture<String> agregarAsincrono2(CuentaBancaria cuentaBancaria) {
        try {
            TimeUnit.SECONDS.sleep(1);
            LOG.info(Thread.currentThread().getName());
            LOG.info("Se inserto la cuenta: " + cuentaBancaria.getNumero());
            this.cuentaBancariaRepository.insertar(cuentaBancaria);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(cuentaBancaria.getNumero());
    }

}
