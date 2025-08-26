package org.algorix.biblioteca.dominio.service;

import org.algorix.biblioteca.persistence.crud.AutorCrud;
import org.algorix.biblioteca.persistence.crud.LibroCrud;
import org.algorix.biblioteca.persistence.entity.Autor;
import org.algorix.biblioteca.persistence.entity.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.security.AuthProvider;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private LibroCrud crud;

    @Autowired
    private AutorCrud crudAutor;

    @Override
    public List<Autor> listarAutores() {
        List<Autor> Autor = crudAutor.findAll();
        return Autor;
    }

    @Override
    public List<Libro> listarLibros() {
        List<Libro> Libros = crud.findAll();
        return Libros;
    }



    @Override
    public ArrayList<Libro> buscarLibroPorAutor(String autor) {
        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Libro> Libro = new ArrayList<>();
        for (Autor a: crudAutor.findAll()) {
            for (Libro l: listarLibros()) {
                if (a.getNombre().equalsIgnoreCase(autor) && l.getId_autor().equals(a.getId_autor())){
                    Libro.add(l);
                }
            }
        }
        return Libro;
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
