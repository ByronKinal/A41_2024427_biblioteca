package org.algorix.biblioteca.persistence.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import lombok.Data;
import org.algorix.biblioteca.dominio.service.ILibroService;
import org.algorix.biblioteca.persistence.entity.Autor;
import org.algorix.biblioteca.persistence.entity.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Named
@Data
public class AutoresController {

    @Autowired
    ILibroService autoreService;
    private List<Autor> autores;
    private Libro autorSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(AutoresController.class);

    @PostConstruct
    public void init() {
        cargarDatos();
    }
    public void cargarDatos() {
        this.autores = this.autoreService.listarAutores();
        this.autores.forEach(autor -> logger.info(autor.toString()));
    }


}
