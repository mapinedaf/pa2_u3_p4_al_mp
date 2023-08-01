package com.example.pa2_u3_p4_al_mp.ejercicioEnClase1707.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "estudiante")
@Entity
public class Estudiante {
    @GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante",allocationSize = 1)
    @Id
    @Column(name = "estu_id")
    private Integer id;
    @Column(name = "estu_nombre")
    private String nombre;
    @Column(name = "estu_apellido")
    private String apellido;
    @Column(name = "estu_cedula")
    private String cedula;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estu_id_provincia")
    private Provincia provincia;
    @OneToMany(mappedBy = "estudiante")
    private List<Matricula> matriculas;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    public List<Matricula> getMatriculas() {
        return matriculas;
    }
    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
                + ", provincia=" + provincia + "]";
    }
    

    

    



    
    
}
