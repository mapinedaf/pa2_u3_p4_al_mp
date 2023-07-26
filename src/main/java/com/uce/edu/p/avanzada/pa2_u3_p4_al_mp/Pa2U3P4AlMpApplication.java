package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.CuentaBancaria;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Propietario;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.ICuentaBancariaService;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.ITransferenciaService;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner {

	@Autowired
	ICuentaBancariaService cuentaBancariaService;

	@Autowired
	ITransferenciaService transferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void run(String... args) throws Exception {

		List<CuentaBancaria> cuentas = new ArrayList<>();
		cuentas.add(CuentaBancaria.builder()
				.numero("0017")
				.saldo(BigDecimal.valueOf(300))
				.tipo('A')
				.build());

		Propietario propietario = Propietario.builder()
				.nombre("Jose")
				.apellido("Lopez")
				.cedula("1234531")
				.cuentas(cuentas)
				.build();
		cuentas.get(0).setPropietario(propietario);

		List<CuentaBancaria> cuentas2 = new ArrayList<>();
		cuentas2.add(CuentaBancaria.builder()
				.numero("0317")
				.saldo(BigDecimal.valueOf(300))
				.tipo('A')
				.build());

		Propietario propietario2 = Propietario.builder()
				.nombre("Alejandro")
				.apellido("Loor")
				.cedula("1857531")
				.cuentas(cuentas2)
				.build();
		cuentas2.get(0).setPropietario(propietario2);

		cuentaBancariaService.guardarCuenta(cuentas.get(0));
		cuentaBancariaService.guardarCuenta(cuentas2.get(0));


		transferenciaService.realizarTransferencia(cuentas.get(0), cuentas2.get(0), BigDecimal.valueOf(400));



		
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive() +" Main");


	}

}
