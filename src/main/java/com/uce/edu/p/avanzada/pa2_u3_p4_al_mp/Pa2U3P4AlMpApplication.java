package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Habitacion;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Hotel;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner {

	@Autowired
	IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Hotel hot1 = Hotel.builder().nombre("Rayito de sol").direccion("av occidental").build();

		Habitacion h1 = Habitacion.builder().numero("001").hotel(hot1).valor(BigDecimal.valueOf(100)).build();
		Habitacion h2 = Habitacion.builder().numero("002").hotel(hot1).valor(BigDecimal.valueOf(100)).build();
		Habitacion h3 = Habitacion.builder().numero("003").hotel(hot1).valor(BigDecimal.valueOf(100)).build();

		List<Habitacion> habi = new ArrayList<>();
		habi.add(h1);
		habi.add(h2);
		habi.add(h3);
		hot1.setHabitaciones(habi);

		System.out.println("---------------------");
		System.out.println("insertar");
		hotelService.agregar(hot1);

		System.out.println("---------------------");
		System.out.println("inner join");

		this.hotelService.buscarInnerJoin();
		System.out.println("---------------------");
		System.out.println("join fetch");
		List<Hotel> listaHotel = this.hotelService.buscarJoinFetch();
		;

		System.out.println("-------------------------------------------------------");

		listaHotel.stream().forEach(x -> {
			System.out.println("-***********************************");
			System.out.println(x.getNombre());
			x.getHabitaciones().stream().forEach(System.out::println);
		});
	}

}
