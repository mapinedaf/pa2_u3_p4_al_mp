package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Estudiante;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Materia;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Provincia;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.Semestre;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.IMatriculaService;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.IProvinciaService;
import com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.service.ISemestreService;

@SpringBootApplication
public class Pa2U3P4AlMpApplication implements CommandLineRunner {

	@Autowired
	IProvinciaService provinciaService;

	@Autowired
	ISemestreService semestreService;

	@Autowired
	IMatriculaService matriculaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AlMpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estudiante e1 = Estudiante.builder()
				.cedula("12344567890").apellido("Perez").nombre("David").build();
		Estudiante e2 = Estudiante.builder()
				.cedula("6453847563").apellido("Perez").nombre("David").build();
		Estudiante e3 = Estudiante.builder()
				.cedula("6344475635").apellido("Perez").nombre("David").build();
		Estudiante e4 = Estudiante.builder()
				.cedula("1965429587").apellido("Perez").nombre("David").build();
		Estudiante e5 = Estudiante.builder()
				.cedula("6323445734").apellido("Perez").nombre("David").build();

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

		//provinciaService.guardar(provincia);

		Semestre semestre = Semestre.builder()
				.nivelSemetre("Sexto")
				.fechaInicio(LocalDate.of(2023, 5, 5))
				.fechaFin(LocalDate.of(2023, 9, 5))
				.build();

		List<Materia> materias = new ArrayList();

		materias.add(
				Materia.builder()
						.cantidadHoras(40)
						.nombre("Redes")
						.codigo("006-RDS")
						.semestre(semestre)
						.build());

		materias.add(
				Materia.builder()
						.cantidadHoras(40)
						.nombre("Programacion Avanzada 2")
						.codigo("006-PA2")
						.semestre(semestre)
						.build());
		materias.add(
				Materia.builder()
						.cantidadHoras(40)
						.nombre("Optimizacion")
						.codigo("006-OPM")
						.semestre(semestre)
						.build());
		materias.add(
				Materia.builder()
						.cantidadHoras(40)
						.nombre("Inteligencia artificial")
						.codigo("006-IA")
						.semestre(semestre)
						.build());
		materias.add(
				Materia.builder()
						.cantidadHoras(40)
						.nombre("Emprendimiento")
						.codigo("006-EMP")
						.semestre(semestre)
						.build());
		semestre.setMaterias(materias);
		//semestreService.guardar(semestre);

		String [] coodMaterias ={"006-RDS","006-PA2","006-OPM","006-IA","006-EMP"};

	


		//estudiantes.stream().forEach(e -> matriculaService.generarMatricula(e.getCedula(), coodMaterias));

		matriculaService.reporteMatriculas().forEach(System.out::println);
		
	}

}
