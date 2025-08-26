package org.algorix.biblioteca.dominio.service;

import org.algorix.biblioteca.persistence.entity.Autor;
import org.algorix.biblioteca.persistence.entity.Libro;

import java.util.ArrayList;
import java.util.List;

public interface ILibroService {
    public List<Libro> listarLibros();
    public ArrayList<Libro> buscarLibroPorAutor(String autor);
    public List<Autor> listarAutores();
    public Libro buscarLibroPorId(Integer id);
    public void guardarLibro(Libro libro);
    public void eliminarLibro(Libro libro);
}
