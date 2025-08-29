package org.algorix.biblioteca.persistence.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Data;
import org.algorix.biblioteca.dominio.service.ILibroService;
import org.algorix.biblioteca.dominio.service.LibroService;
import org.algorix.biblioteca.persistence.entity.Libro;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Named
@Data
public class LibrosController {

    @Autowired
    ILibroService libroService;
    private List<Libro> libros;
    private Libro libroSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(LibrosController.class);
    Logger looger = LoggerFactory.getLogger(LibrosController.class);

    @PostConstruct
    public void init() {
        cargarDatos();
    }
    public void cargarDatos() {
        this.libros = this.libroService.listarLibros();
        this.libros.forEach(libro -> logger.info(libro.toString()));
    }

    public void agregarLibro() {
        this.libroSeleccionado = new Libro();
    }

    public void guardarLibro() {
        looger.info("Cliente a guardar: " + this.libroSeleccionado);
        if (this.libroSeleccionado.getId() == null) {
            this.libroService.guardarLibro(this.libroSeleccionado);
            this.libros.add(this.libroSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Libro Agregado"));
        }
        else {
            this.libroService.guardarLibro(this.libroSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Libro Modificado"));
        }
        //ocultar la ventana modal
        PrimeFaces.current().executeScript("PF('ventanaModalLibro').hide()");
        PrimeFaces.current().ajax().update("formulario-libros:mensaje_emergente","formulario-libros:tabla-libros");
        this.libroSeleccionado = null;
    }

    public void eliminarLibro() {
        //mostrar en consola
        looger.info("Libro a eliminar: " + this.libroSeleccionado);
        //llamar a nuesto servicio de eliminarcion de cliente
        this.libroService.eliminarLibro(libroSeleccionado);
        //eliminarlo de la lista clientes
        this.libros.remove(this.libroSeleccionado);
        //limpiar nuestro cliente seleccionado
        this.libroSeleccionado = null;
        //enviar un mensaje emergente de confirmacion
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Libro Eliminado"));
        //actualizar la tabla con ajax
        PrimeFaces.current().ajax().update(
                "formulario-libros:mensaje_emergente",
                "formulario-libros:tabla-libros"
        );
    }

}
