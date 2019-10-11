create database segurobd;
use segurobd;

create table if not exists segurado(
	nome varchar (80) not null,
    cpf varchar(11) not null,
    rg varchar(10) not null,
    sexo varchar(10),
    correntista boolean,
    dataNascimento date,
    dataCadastro date,
    diasVisita integer,
    primary key(cpf)
);

create table if not exists seguro(
	id integer not null auto_increment,
    seguro varchar(50),
    valor double,
    primary key(id)
);
create table if not exists segurado_seguro(
	cpf_segurado varchar(11),
    id_seguro integer,
    constraint foreign key (cpf_segurado) references segurado (cpf),
    constraint foreign key (id_seguro) references seguro (id),
    primary key (cpf_segurado, id_seguro)
);

create table if not exists login(
	usuario varchar(55),
    senha varchar(55),
    primary key (usuario, senha)
);

create table if not exists semana(
	id integer auto_increment not null,
	dia varchar(15),
    primary key (id)
);

create table if not exists segurado_semana(
	id_dia integer,
	cpf_segurado varchar(11),
    primary key (id_dia, cpf_segurado),
    constraint foreign key (id_dia) references semana (id),
    constraint foreign key (cpf_segurado) references segurado (cpf)
);

insert into semana values (null, 'Segunda');
insert into semana values (null, 'Terça');
insert into semana values (null, 'Quarta');
insert into semana values (null, 'Quinta');
insert into semana values (null, 'Sexta');

alter table segurado drop column diasVisita;

select * from segurado;

select * from semana;

select * from seguro;
alter table segurado add column dataAlteracao date;
drop table segurado;
	