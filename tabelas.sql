drop table if exists refeicao;
drop table if exists reajuste;
drop table if exists usuario;
drop table if exists tipo;
drop table if exists funcionario;
drop table if exists cargo;

create table tipo (
	id integer,
	nome varchar(25),
	primary key(id)
);

create table usuario (
	ra varchar(7),
	senha varchar(8),
	nome varchar(40),
	tipo integer,
	foto varchar(256),
	primary key(ra),
	foreign key(tipo) references tipo (id)
);

create table reajuste(
	id integer,
	data date,
	valor float,
	obs varchar(256),
	primary key(id)
);

create table refeicao(
	timestamp varchar(15),
	ra varchar(7),
	quantidade integer,
	reajuste integer,
	saldo integer,
	primary key(timestamp),
	foreign key(reajuste) references reajuste (id),
	foreign key(ra) references usuario (ra)
);

create table cargo(
	id integer,
	nome varchar(30),
	primary key(id)
);

create table funcionario(
	id integer,
	nome varchar(40),
	id_funcionario integer,
	primary key(id),
	foreign key(id_funcionario) references cargo (id)
);