create table candidatos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    email varchar(100) not null unique,
    profissao varchar(100) not null,
    logradouro varchar(100) not null,
    numero varchar(20),
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    cep varchar(8) not null,
    uf char(2) not null,
    complemento varchar(100),

    primary key(id)

);