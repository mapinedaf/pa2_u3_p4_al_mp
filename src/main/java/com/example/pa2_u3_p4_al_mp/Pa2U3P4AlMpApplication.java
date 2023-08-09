package com.example.pa2_u3_p4_al_mp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.repository.modelo.CuentaBancaria;

import com.example.pa2_u3_p4_al_mp.tarea12_banco.serrvice.ICuentaBancariaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4AlMpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4AlMpApplication.class);
	@Autowired
	ICuentaBancariaService cuentaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Asincron sin respuesta
		 * LOG.info("Hilo: " + Thread.currentThread().getName());
		 * 
		 * long init = System.currentTimeMillis();
		 * 
		 * List<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
		 * 
		 * for (int i = 1; i <= 10; i++) {
		 * 
		 * CuentaBancaria cuentaBancaria = new CuentaBancaria();
		 * 
		 * cuentaBancaria.setNumero("" + i);
		 * 
		 * cuentas.add(cuentaBancaria);
		 * 
		 * this.cuentaBancariaService.agregarAsincrono(cuentaBancaria);
		 * 
		 * }
		 * 
		 * long finl = System.currentTimeMillis();
		 * 
		 * long timeSpan = (finl - init);
		 * 
		 * LOG.info("Tiempo transcurrido (ms): " + timeSpan);
		 * 
		 */

		// Asincron futuro con respuesta

		LOG.info("Hilo: " + Thread.currentThread().getName());

		long init = System.currentTimeMillis();

		List<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();

		List<CompletableFuture<String>> respuestas = new ArrayList<CompletableFuture<String>>();

		for (int i = 1; i <= 10; i++) {

			CuentaBancaria cuentaBancaria = new CuentaBancaria();

			cuentaBancaria.setNumero("" + i);

			cuentas.add(cuentaBancaria);

			CompletableFuture<String> respuesta = this.cuentaBancariaService.agregarAsincrono2(cuentaBancaria); // Promesa
																												// de
																												// respuesta

			respuestas.add(respuesta);

		}

		//Sentencia que espera de proesarce tods los hilos para obtener la respuesta
		CompletableFuture.allOf(respuestas.get(0),
				respuestas.get(1),
				respuestas.get(2),
				respuestas.get(3),
				respuestas.get(4),
				respuestas.get(5),
				respuestas.get(6),
				respuestas.get(7),
				respuestas.get(8),
				respuestas.get(9));

				LOG.info("Respuesta 0: "+ respuestas.get(0).get());

		long finl = System.currentTimeMillis();

		long timeSpan = (finl - init);

		LOG.info("Tiempo transcurrido (ms): " + timeSpan);

	}

}
