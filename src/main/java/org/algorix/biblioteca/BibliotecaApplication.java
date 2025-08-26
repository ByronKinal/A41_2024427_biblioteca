package org.algorix.biblioteca;

import org.algorix.biblioteca.dominio.service.ILibroService;
import org.algorix.biblioteca.persistence.entity.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	private ILibroService libroService;

	private static final Logger logger = LoggerFactory.getLogger(BibliotecaApplication.class);

	String sl = System.lineSeparator();

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
        logger.info("++++++aplicacion de biblioteca++++++");
        var salir = false;
        var consola = new Scanner(System.in);
        while (!salir){
            var opcion = menu(consola);
            salir = ejecutarOpciones(consola,opcion);
            logger.info(sl);
        }
	}

	private int menu (Scanner consola){
		logger.info("""
				\n ++++++Aplicacion++++++
				1.Listar todos los libros.
				2.Buscar por autor
				3.Agregar nuevo libro
				4.Modificar libro.
				5.Eliminar libro.
				6.Salir.
				Elije una opcion: \s""");
		var opcion = Integer.parseInt(consola.nextLine());
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		var salir = false;
		switch (opcion) {
			case 1 -> {
				logger.info(sl+"Listado de libros"+sl);
				List<Libro> libros = libroService.listarLibros();
				libros.forEach(Libro -> logger.info(Libro.toString()+sl));
			}
            case 2 -> {
                logger.info(sl+"Buscar libro por autor");
                logger.info("Ingrese el nombre del autor: ");
                String autor = consola.nextLine();
                ArrayList<Libro> libro = libroService.buscarLibroPorAutor(autor);
                for(Libro l : libro) {
                    logger.info("Libro encontrado: " + l);
                }
            }
            case 3 -> {
                logger.info(sl+"Agregar nuevo libro"+sl);
                Libro libro = new Libro();
                logger.info("Ingrese el titulo del libro: ");
                libro.setTitulo(consola.nextLine());
                logger.info("Ingrese el autor del libro: ");
                libro.setId_autor(Integer.parseInt(consola.nextLine()));
                logger.info("Ingrese el genero del libro: ");
                libro.setGenero(consola.nextLine());
                logger.info("Ingrese la cantidad de libros: ");
                libro.setCantidad(Integer.parseInt(consola.nextLine()));
                logger.info("Ingrese la ubicacion del libro: ");
                libro.setUbicacion(consola.nextLine());
                libroService.guardarLibro(libro);
                logger.info("Libro agregado correctamente: " + libro.toString());
            }
            case 4 -> {
                logger.info(sl+"Modificar libro"+sl);
                logger.info("Ingrese el ID del libro a modificar: ");
                var id = Integer.parseInt(consola.nextLine());
                Libro libro = libroService.buscarLibroPorId(id);
                if (libro != null) {
                    logger.info("Ingrese el nuevo titulo del libro: ");
                    libro.setTitulo(consola.nextLine());
                    logger.info("Ingrese el nuevo autor del libro: ");
                    libro.setId_autor(Integer.parseInt(consola.nextLine()));
                    logger.info("Ingrese el nuevo genero del libro: ");
                    libro.setGenero(consola.nextLine());
                    logger.info("Ingrese la nueva cantidad de libros: ");
                    libro.setCantidad(Integer.parseInt(consola.nextLine()));
                    logger.info("Ingrese la nueva ubicacion del libro: ");
                    libro.setUbicacion(consola.nextLine());
                    libroService.guardarLibro(libro);
                    logger.info("Libro modificado correctamente: " + libro.toString());
                } else {
                    logger.error("Libro no encontrado con ID: " + id);
                }
            }
            case 5 -> {
                logger.info(sl+"Eliminar libro"+sl);
                logger.info("Ingrese el ID del libro a eliminar: ");
                var id = Integer.parseInt(consola.nextLine());
                Libro libro = libroService.buscarLibroPorId(id);
                if (libro != null) {
                    libroService.eliminarLibro(libro);
                    logger.info("Libro eliminado correctamente: " + libro.toString());
                } else {
                    logger.error("Libro no encontrado con ID: " + id);
                }
            }
            case 6 -> {
                salir = true;
                logger.info("Saliendo de la aplicacion...");
            }
            default -> logger.warn("Opcion no valida, por favor intente de nuevo.");
		}
		return salir;
	}
}
