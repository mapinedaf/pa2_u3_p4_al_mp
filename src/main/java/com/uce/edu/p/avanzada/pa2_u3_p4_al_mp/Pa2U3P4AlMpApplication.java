package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Boleto;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Vuelo;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.IBoletoService;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.IVueloService;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner {

	@Autowired
	IVueloService vueloService;

	@Autowired
	IBoletoService boletoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Boleto> boletos1 = new ArrayList<>();

		boletos1.add(
				Boleto.builder()
						.numero("001")
						.nombrePasajero("David Estrella")
						.clase("Economica")
						.asiento("B-03")
						.puertaAbordaje("4")
						.precio(BigDecimal.valueOf(300))
						.build());

		boletos1.add(
				Boleto.builder()
						.numero("006")
						.nombrePasajero("Juan Gonzales")
						.clase("Negocios")
						.asiento("C-13")
						.puertaAbordaje("3")
						.precio(BigDecimal.valueOf(500))
						.build());

		Vuelo vuelo1 = Vuelo.builder()
				.codigo("MH-001")
				.origen("LAX")
				.destino("UIO")
				.identificadorAvion("bng-004")
				.boletos(boletos1)
				.build();

		boletos1.stream().forEach(x -> x.setVuelo(vuelo1));

		List<Boleto> boletos2 = new ArrayList<>();

		boletos2.add(
				Boleto.builder()
						.numero("001")
						.nombrePasajero("Richard Nixon")
						.clase("Economica")
						.asiento("B-04")
						.puertaAbordaje("4")
						.precio(BigDecimal.valueOf(100))
						.build());

		Vuelo vuelo2 = Vuelo.builder()
				.codigo("MJ-034")
				.origen("GYE")
				.destino("UIO")
				.identificadorAvion("bng-101")
				.boletos(boletos2)
				.build();

		boletos2.stream().forEach(x -> x.setVuelo(vuelo2));

		Vuelo vuelo3 = Vuelo.builder()
				.codigo("NA-334")
				.origen("GYE")
				.destino("NYC")
				.identificadorAvion("bng-101")
				.build();

		// vueloService.agregar(vuelo1);
		// vueloService.agregar(vuelo2);
		// vueloService.agregar(vuelo3);

		System.out.println("-----------------------------------");
		System.out.println("Inner join");
		System.out.println("1)");
		vueloService.buscarInnerJoin();
		System.out.println("2)");
		boletoService.buscarInnerJoin();
		System.out.println("-----------------------------------");
		System.out.println("Right join");
		System.out.println("1)");
		vueloService.buscarRightJoin();
		System.out.println("2");
		boletoService.buscarRightJoin();
		System.out.println("-----------------------------------");
		System.out.println("Left join");
		System.out.println("1)");
		vueloService.buscarLeftJoin();
		System.out.println("2)");
		boletoService.buscarLeftJoin();
		System.out.println("-----------------------------------");
		System.out.println("Full join");
		System.out.println("1)");
		vueloService.buscarFullJoin();
		System.out.println("2)");
		boletoService.buscarFullJoin();
		System.out.println("-----------------------------------");
		System.out.println("Join Where");
		System.out.println("1)");
		vueloService.buscarJoinWhere();
		System.out.println("2)");
		boletoService.buscarJoinWhere();
		System.out.println("-----------------------------------");
		System.out.println("Join Fetch");
		System.out.println("1)");
		vueloService.buscarJoinFetch();
		System.out.println("2)");
		boletoService.buscarJoinFetch();
	}

}
