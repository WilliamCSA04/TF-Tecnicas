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
