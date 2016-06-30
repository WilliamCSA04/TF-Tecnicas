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

CREATE TABLE IF NOT EXISTS mapa_assentos (
    id SERIAL,
    poltrona1 BOOLEAN,
    poltrona2 BOOLEAN,
    poltrona3 BOOLEAN,
    poltrona4 BOOLEAN,
    poltrona5 BOOLEAN,
    poltrona6 BOOLEAN,
    poltrona7 BOOLEAN,
    poltrona8 BOOLEAN,
    poltrona9 BOOLEAN,
    poltrona10 BOOLEAN,

    CONSTRAINT PK_MAPA_ASSENTOS PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS voos (
    id SERIAL,
    partida TIME,
    chegada TIME,
    id_rota INTEGER,
    id_mapa_assentos INTEGER,
    data_partida DATE,

    CONSTRAINT PK_VOOS PRIMARY KEY (id),
    CONSTRAINT FK_VOOS_ROTAS FOREIGN KEY (id_rota) REFERENCES rotas (id),
    CONSTRAINT FK_MAPA_ASSENTOS FOREIGN KEY (id_mapa_assentos) REFERENCES mapa_assentos(id)
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
    
    id SERIAL,
    voo_id INTEGER,
    passageiro_id VARCHAR,
    status VARCHAR,

    CONSTRAINT PK_PASSAGEM PRIMARY KEY (id),
    CONSTRAINT FK_VOO FOREIGN KEY (voo_id) REFERENCES voos(id),
    CONSTRAINT FK_PASSAGEIRO FOREIGN KEY (passageiro_id) REFERENCES passageiros(id)
);

