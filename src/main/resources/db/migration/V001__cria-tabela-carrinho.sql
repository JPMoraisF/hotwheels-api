create table carrinho (
	id int not null auto_increment,
	nome varchar(30) not null,
    fabricante varchar(30)not null,
    pais_fabricacao varchar(30) not null,
    ano int not null,
    cor varchar(15),
    
    primary key(id)
);