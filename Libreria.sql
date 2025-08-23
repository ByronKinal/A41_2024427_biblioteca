drop database if exists DBBiblioteca;
create database DBBiblioteca;
use DBBiblioteca;

create table libros(
id integer auto_increment, 
titulo varchar(256),
autor varchar(256),
genero enum('masculino','femenino','codigoBinario'),
cantidad int,
ubicacion varchar(256),
constraint pk_idlibro primary key (id)
);

INSERT INTO libros (titulo, autor, genero, cantidad, ubicacion) VALUES
('cien años de soledad', 'gabriel garcía márquez', 'masculino', 5, 'estante a-1'),
('don quijote de la mancha', 'miguel de cervantes', 'masculino', 3, 'estante b-2'),
('la casa de los espíritus', 'isabel allende', 'femenino', 4, 'estante c-3'),
('la ciudad y los perros', 'mario vargas llosa', 'masculino', 2, 'estante d-4'),
('como agua para chocolate', 'laura esquivel', 'femenino', 6, 'estante a-2');

select * from libros;