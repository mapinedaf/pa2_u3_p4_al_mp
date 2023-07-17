package com.uce.edu.p.avanzada.pa2_u3_p4_al_mp.repository.modelo;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="hotel")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Hotel {

    @GeneratedValue(generator = "seq_hotel", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_hotel", sequenceName = "seq_hotel",allocationSize = 1)
    @Id
    @Column(name = "hot_id")
    private Integer id;
    @Column(name = "hot_nombre")
    private String nombre;
    @Column(name = "hot_direccion")
    private String direccion;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones;

    
}
