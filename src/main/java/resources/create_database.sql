CREATE TABLE IF NOT EXISTS aeroportos(
    id VARCHAR,
    nome VARCHAR,

    CONSTRAINT PK_AEROPORTOS PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS voos (
    id VARCHAR,

    CONSTRAINT PK_VOOS PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS rotas(
    
    origem VARCHAR,
    destino VARCHAR,

    CONSTRAINT fk_rotas_origem FOREIGN KEY (origem) REFERENCES aeroportos (id),
    CONSTRAINT fk_rotas_destino FOREIGN KEY (destino) REFERENCES aeroportos (id)

);
--id, nome, sobrenome, genero, data_nascimento, endereco, email, rg, cpf, passaporte 
CREATE TABLE IF NOT EXISTS passageiros{
    
    id VARCHAR,
    nome VARCHAR,
    sobrenome VARCHAR,
    genero VARCHAR,   
    data_nascimento DATE,
    endereco VARCHAR,
    email VARCHAR,
    rg VARCHAR,
    cpf VARCHAR,
    passaporte VARCHAR,
    senha VARCHAR
};

CREATE IF NOT EXISTS passagens(
    
    id VARCHAR,
    rota VARCHAR,
    data_embaque VARCHAR,
    passageiro_id VARCHAR,

    CONSTRAINT PK_PASSAGEM PRIMARY KEY (id),
    CONSTRAINT FK_AEROPORTO FOREIGN KEY (rota) REFERENCES rotas(id)
);
