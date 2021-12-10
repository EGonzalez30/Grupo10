create database g10;
use g10;

create table empleados( 
id_empleado int not null primary key auto_increment,
dni int not null,
numero_ss int not null,
cod_trabajador varchar(200) not null,
nombre varchar(100) not null,
apellido varchar(100) not null,
direccion varchar(150) not null,
telefono varchar(50) not null
);


create table cargo(
id_cargo int not null primary key auto_increment,
id_empleado int not null,
id_departamento int not null,
tipo_cargo varchar(150) not null
);


create table contrato(
id_contrato int not null primary key auto_increment,
id_empleado int not null,
fecha_inicial varchar(250) not null,
fecha_final varchar(250) not null
);


create table nominas(
id_nomina int primary key auto_increment not null,
id_empleado int not null,
id_cargo int not null,
fecha_nacimiento varchar(250) not null,
salario double
);


create table departamentos(
id_departamento int not null primary key auto_increment,
departamento varchar(100) not null,
ciudad varchar(100) not null,
area_trabajo varchar(100) not null
);


create table usuarios(
id int not null primary key auto_increment,
nombre varchar(100) not null,
apellido varchar(100) not null,
usuario varchar(50)not null,
clave varchar(50) not null
);


alter table cargo add foreign key(id_empleado) references empleados(id_empleado);
alter table cargo add foreign key(id_departamento) references departamentos(id_departamento);
alter table contrato add foreign key(id_empleado) references empleados(id_empleado);
alter table nominas add foreign key(id_empleado) references empleados(id_empleado);
alter table nominas add foreign key(id_cargo) references cargo(id_cargo);
alter table profesiones add foreign key(id_empleado) references empleados(id_empleado);
alter table profesiones add foreign key(id_departamento) references departamentos(id_departamento);





















































































