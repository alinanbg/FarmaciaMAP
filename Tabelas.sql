create table farmacia(
	codigo serial primary key,
	cnpj text,
	nome text,
	telefone text,
	email text
);

create table endereco(
	codigo serial primary key,
	rua text,
	bairro text,
	numero integer,
	cidade text,
	estado text,
	cep text
);

alter table farmacia add column id_endereco integer references endereco(codigo)

create table remedio(
	codigo serial primary key,
	nome text,
	laboratorio text,
	codigo_barra text
);

create table vende(
	id_remedio integer references remedio(codigo),
	id_farmacia integer references farmacia(codigo),
	primary key(id_remedio, id_farmacia)
);
