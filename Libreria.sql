drop database if exists DBBiblioteca;
create database DBBiblioteca;
use DBBiblioteca;

create table libros(
id integer auto_increment, 
titulo varchar(256),
autor varchar(256),
genero enum('masculino','femenino','codigoBinario'),
cantidad int,
constraint pk_idlibro primary key (id)
);