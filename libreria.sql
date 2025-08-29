drop database if exists DBBiblioteca;
create database DBBiblioteca;
use DBBiblioteca;

create table autor(
id_autor int auto_increment,
nombre varchar(256),
apellido varchar (256),
constraint pk_idautor primary key(id_autor)
);


create table libros(
id integer auto_increment, 
titulo varchar(256),
id_autor int,
genero varchar(256),
cantidad int,
ubicacion varchar(256),
constraint pk_idlibro primary key (id),
constraint fk_idAUtor foreign key (id_autor) 
	references autor(id_autor)
);


insert into autor(nombre, apellido) 
values 
("juan1","perez"),
("juan2","perez"),
("juan3","perez"),
("juan3","perez"),
("juan","perez");


INSERT INTO libros (titulo, id_autor, genero, cantidad, ubicacion) VALUES
('cien años de soledad', 1, "Comedia", 5, 'estante a-1'),
('don quijote de la mancha', 2, "Accion", 3, 'estante b-2'),
('la casa de los espíritus', 3, "Romance", 4, 'estante c-3'),
('la ciudad y los perros', 4, "Eso tilin", 2, 'estante d-4'),
('como agua para chocolate', 5, "Eso no tilin", 6, 'estante a-2');




select * from libros;
