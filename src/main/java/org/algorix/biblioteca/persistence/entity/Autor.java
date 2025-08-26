package org.algorix.biblioteca.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "autor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_autor;
    @Column
    private String nombre;
    private String apellido;
}
