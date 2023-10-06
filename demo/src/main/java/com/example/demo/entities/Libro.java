package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Table(name = "libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Libro extends Base{
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    private int fecha;
    @Column(name = "genero")
    private String genero;
    @Column(name = "paginas")
    private int paginas;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Persona persona;
    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores;
}