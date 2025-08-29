package org.algorix.biblioteca.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "libros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String titulo;
    private Integer id_autor;
    private String genero;
    private Integer cantidad;
    private String ubicacion;

}
