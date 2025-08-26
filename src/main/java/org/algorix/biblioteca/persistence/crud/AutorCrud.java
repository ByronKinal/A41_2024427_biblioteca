package org.algorix.biblioteca.persistence.crud;

import org.algorix.biblioteca.persistence.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorCrud extends JpaRepository<Autor, Integer> {
}
