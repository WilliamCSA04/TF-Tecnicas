CREATE TABLE IF NOT EXISTS aeroportos(
    id VARCHAR,
    nome VARCHAR,

    CONSTRAINT PK_AEROPORTOS PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS rotas(
    
    id SERIAL,
    origem VARCHAR,
    destino VARCHAR,
    
    CONSTRAINT pk_rotas PRIMARY KEY (id),
    CONSTRAINT fk_rotas_origem FOREIGN KEY (origem) REFERENCES aeroportos (id),
    CONSTRAINT fk_rotas_destino FOREIGN KEY (destino) REFERENCES aeroportos (id)

);

CREATE TABLE IF NOT EXISTS voos (
    id SERIAL,
    partida TIME,
    chegada TIME,
    id_rota INTEGER,
    data_partida DATE,

    CONSTRAINT PK_VOOS PRIMARY KEY (id),
    CONSTRAINT FK_VOOS_ROTAS FOREIGN KEY (id_rota) REFERENCES rotas (id)
);



CREATE TABLE IF NOT EXISTS passageiros(
    
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
    senha VARCHAR,

    CONSTRAINT PK_PASSAGEIROS PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS passagens(
    
    id VARCHAR,
    voo_id INTEGER,
    passageiro_id VARCHAR,
    status VARCHAR,

    CONSTRAINT PK_PASSAGEM PRIMARY KEY (id),
    CONSTRAINT FK_VOO FOREIGN KEY (voo_id) REFERENCES voos(id),
    CONSTRAINT FK_PASSAGEIRO FOREIGN KEY (passageiro_id) REFERENCES passageiros(id)
);

CREATE TABLE IF NOT EXISTS assentos(

    id SERIAL,
    poltrona INTEGER,

    CONSTRAINT PK_ASSENTO PRIMARY KEY (id)

);
