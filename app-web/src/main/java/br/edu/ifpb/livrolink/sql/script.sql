CREATE TABLE Sessao (
	id_sessao SERIAL PRIMARY KEY,
	generosessao VARCHAR(50) NOT NULL,
	quantidadeLivrosGenero INT DEFAULT 0
);

CREATE TABLE Usuario (
	id_usuario SERIAL PRIMARY KEY,
	nome VARCHAR(80) NOT NULL,
	idade INT NOT NULL,
	cpf VARCHAR(11) UNIQUE NOT NULL,
	sexo CHAR(1)
);

CREATE TABLE livro (
	cod_livro SERIAL PRIMARY KEY,
	nomedolivro VARCHAR(100) NOT NULL,
	generodolivro VARCHAR(80) NOT NULL,
	autordolivro VARCHAR(100) NOT NULL,
	editoradolivro VARCHAR(100) NOT NULL,
	ocupado BOOLEAN DEFAULT FALSE,
	id_usuario INT,
	id_sessao INT,

	CONSTRAINT fk_livro_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
	CONSTRAINT fk_livro_sessao FOREIGN KEY (id_sessao) REFERENCES sessao(id_sessao)
);

CREATE TABLE reserva (
    id_reserva SERIAL PRIMARY KEY,
    cod_livro INT NOT NULL,
    id_usuario INT NOT NULL,
    data_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_reserva_livro FOREIGN KEY (cod_livro) REFERENCES livro(cod_livro),
    CONSTRAINT fk_reserva_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);