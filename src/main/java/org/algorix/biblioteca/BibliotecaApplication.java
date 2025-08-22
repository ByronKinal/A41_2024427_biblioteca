package org.algorix.biblioteca;

import org.algorix.biblioteca.dominio.service.ILibroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

	private int ejecutarOpciones(Scanner consola, int opcion)
}
