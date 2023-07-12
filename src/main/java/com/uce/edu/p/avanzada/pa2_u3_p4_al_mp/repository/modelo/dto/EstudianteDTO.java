package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor 

public class EstudianteDTO {

    private String nombre;

    private String apellido;


}
