package org.algorix.biblioteca.dominio.service;

import org.algorix.biblioteca.persistence.crud.LibroCrud;
import org.algorix.biblioteca.persistence.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private LibroCrud crud;

    @Override
    public List<Libro> listarLibros() {
        List<Libro> Libros = crud.findAll();
        return Libros;
    }

    @Override
    public ArrayList<Libro> buscarLibroPorAutor(String autor) {
        ArrayList<Libro> librosEncontrado = new ArrayList<>();
        List<Libro> buscar = listarLibros();
        for (Libro libro : buscar) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                librosEncontrado.add(libro);
            }
        }
        return librosEncontrado;
    }

    @Override
    public Libro buscarLibroPorId(Integer id) {
        Libro libro = crud.findById(id).orElse(null);
        return libro;
    }


    @Override
    public void guardarLibro(Libro libro) {
        crud.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        crud.delete(libro);
    }
}
