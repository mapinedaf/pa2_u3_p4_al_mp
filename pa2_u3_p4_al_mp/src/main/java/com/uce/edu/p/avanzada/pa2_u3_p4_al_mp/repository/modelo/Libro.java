package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name= "libro")
@Entity
public class Libro {
    
    @Id
    @GeneratedValue(generator = "sec_libro", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_libro", sequenceName = "sec_libro", allocationSize = 1)
    @Column(name = "lib_id")
    private Integer id;
    @Column(name ="lib_titulo")
    private String titulo;
    @Column(name="lib_editorial")
    private String editorial;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "autor_libro", //nombre de la tabla
        joinColumns = @JoinColumn(name="auli_id_libro"), //clave primaria
        inverseJoinColumns = @JoinColumn(name="auli_id_autor") //
        ) //Tabla de rompimiento
    private Set <Autor> autores;
}
