package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
@Table(name="autor")
public class Autor {
    @Id
    @GeneratedValue(generator = "sec_autor", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sec_autor", sequenceName = "sec_autor", allocationSize = 1)
    @Column(name = "aut_id")
    private Integer id;
    @Column(name= "aut_nombre")
    private String nombre;
    @Column(name= "aut_apellido")
    private String apellido;
    
    @ManyToMany(mappedBy = "autores",cascade = CascadeType.ALL)
    private Set<Libro> libros;




}
