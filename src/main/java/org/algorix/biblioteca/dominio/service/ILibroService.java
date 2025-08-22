package org.algorix.biblioteca.dominio.service;

import org.algorix.biblioteca.persistence.entity.Libro;
import java.util.List;

public interface ILibroService {
    public List<Libro> listarLibros();
    public Libro buscarLibroPorAutor(String autor);
    public void guardarLibro(Libro libro);
    public void eliminarLibro(Libro libro);
}
