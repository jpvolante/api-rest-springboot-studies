CREATE TABLE Conserto (
    id bigint NOT NULL AUTO_INCREMENT,
    data_entrada varchar(10) NOT NULL,
    data_saida varchar(10),
    nome_mecanico varchar(100) not null,
    anos_experiencia int,
    marca varchar(100) not null,
    modelo varchar(100) not null,
    ano int,
    PRIMARY KEY (id)
);