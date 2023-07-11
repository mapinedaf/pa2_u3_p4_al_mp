package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp;

import java.math.BigDecimal;
import java.util.ArrayList;

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

		Hotel hot1 = Hotel.builder().nombre("axxios").build();

		Habitacion h1 = Habitacion.builder().numero("001").valor(BigDecimal.valueOf(100)).build();
		Habitacion h2 = Habitacion.builder().numero("002").valor(BigDecimal.valueOf(100)).build();
		Habitacion h3 = Habitacion.builder().numero("003").valor(BigDecimal.valueOf(100)).build();

		ArrayList <Habitacion > list = new ArrayList<>();
		list.add(h1);
		list.add(h2);
		list.add(h3);
		hot1.setHabitaciones(list);
		hotelService.agregar(hot1);
		System.out.println(hotelService.buscarInnerJoin());
	}

}
