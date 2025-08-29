drop database if exists DBBiblioteca;
create database DBBiblioteca;
use DBBiblioteca;

create table autor(
id_autor int auto_increment,
nombre varchar(256),
apellido varchar (256),
constraint pk_idautor primary key(id_autor)
);

create table generos(
id_genero int auto_increment,
nombre varchar (256),
constraint pk_idgenero primary key (id_genero)
);

create table libros(
id integer auto_increment, 
titulo varchar(256),
id_autor int,
id_genero int,
cantidad int,
ubicacion varchar(256),
constraint pk_idlibro primary key (id),
constraint fk_idAUtor foreign key (id_autor) 
	references autor(id_autor),
constraint fk_idGeneror foreign key (id_genero) 
	references generos(id_genero)
);


insert into autor(nombre, apellido) 
values 
("juan1","perez"),
("juan2","perez"),
("juan3","perez"),
("juan3","perez"),
("juan","perez");

INSERT INTO generos (nombre) VALUES
("Comedia"),
("romance"),
("Drama"),
('Accion'),
('H');

INSERT INTO libros (titulo, id_autor, id_genero, cantidad, ubicacion) VALUES
('cien años de soledad', 1, 1, 5, 'estante a-1'),
('don quijote de la mancha', 2, 2, 3, 'estante b-2'),
('la casa de los espíritus', 3, 3, 4, 'estante c-3'),
('la ciudad y los perros', 4, 4, 2, 'estante d-4'),
('como agua para chocolate', 5, 5, 6, 'estante a-2');




select * from libros;
