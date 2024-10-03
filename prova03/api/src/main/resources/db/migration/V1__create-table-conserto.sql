create table conserto(
    id BIGINT AUTO_INCREMENT,
    data_entrada DATE,
    data_saida DATE,
    marca VARCHAR(100),
    model VARCHAR(100),
    ano INT,
    nome VARCHAR(100),
    anos_experiencia INT,
    PRIMARY KEY(id)
);