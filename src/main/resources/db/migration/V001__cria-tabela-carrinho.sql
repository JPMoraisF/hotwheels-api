create table if not exists carrinho (
	id SERIAL,
	nome varchar(30) not null,
    fabricante varchar(30)not null,
    pais_fabricacao varchar(30) not null,
    ano int not null,
    cor varchar(15)
);