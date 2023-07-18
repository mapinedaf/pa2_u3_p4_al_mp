package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Provincia;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.IMatriculaService;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.IProvinciaService;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.ISemetreService;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner {

	@Autowired
	IProvinciaService provinciaService;

	@Autowired
	ISemetreService semetreService;

	@Autowired
	IMatriculaService matriculaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estudiante e1 = Estudiante.builder()
				.cedula("1234").apellido("Perez").nombre("David").build();
		Estudiante e2 = Estudiante.builder()
				.cedula("1234").apellido("Perez").nombre("David").build();
		Estudiante e3 = Estudiante.builder()
				.cedula("1234").apellido("Perez").nombre("David").build();
		Estudiante e4 = Estudiante.builder()
				.cedula("1234").apellido("Perez").nombre("David").build();
		Estudiante e5 = Estudiante.builder()
				.cedula("1234").apellido("Perez").nombre("David").build();

		ArrayList<Estudiante> estudiantes = new ArrayList<>();

		estudiantes.add(e1);
		estudiantes.add(e2);
		estudiantes.add(e3);
		estudiantes.add(e4);
		estudiantes.add(e5);


		Provincia provincia = Provincia.builder()
				.nombre("Pichincha").capital("Quito").region("sierra").build();

		estudiantes.stream().forEach(x -> x.setProvincia(provincia));
		
		provincia.setEstudiantes(estudiantes);

		provinciaService.guardar(provincia);
	}

}
