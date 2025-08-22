package org.algorix.biblioteca.persistence.crud;

import org.algorix.biblioteca.persistence.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroCrud extends JpaRepository<Libro, Integer> {

}
