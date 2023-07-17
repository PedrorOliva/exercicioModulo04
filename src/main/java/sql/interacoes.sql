-- Criando banco
CREATE DATABASE
  resistencia;

-- Criando tabelas
CREATE TABLE
  rebelde (
    id_rebelde SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    idade INTEGER,
    genero TEXT,
    localizacao TEXT,
    traidor INTEGER,
    status BOOLEAN
  );

CREATE TABLE
  inventario (
    id_inventario SERIAL PRIMARY KEY,
    rebelde_id INTEGER,
    arma INTEGER,
    municao INTEGER,
    agua INTEGER,
    comida INTEGER,
    FOREIGN KEY (rebelde_id) REFERENCES rebelde (id_rebelde)
  );

-- Inserindo dados na tabela Rebelde
INSERT INTO rebelde (nome, idade, genero, localizacao, traidor, status)
VALUES ('Dylavin Folkper', '43', 'Male', 'Jakku', '0', 'true');
INSERT INTO rebelde (nome, idade, genero, localizacao, traidor, status)
VALUES ('Jevoedu Hazeburr', '52', 'Male', 'Chandrila', '0', 'true');
INSERT INTO rebelde (nome, idade, genero, localizacao, traidor, status)
VALUES ('Tesskar Bircobl', '433', 'Female', 'Shili', '0', 'true');
INSERT INTO rebelde (nome, idade, genero, localizacao, traidor, status)
VALUES ('Abbykayl Biahen', '493', 'Unknown', 'Coruscant', '0', 'true');
INSERT INTO rebelde (nome, idade, genero, localizacao, traidor, status)
VALUES ('Hassdavi Winbra', '23', 'Male', 'Dagobah', '0', 'true');

SELECT * FROM rebelde;

-- Inserindo dados na table Inventario
INSERT INTO inventario (rebelde_id, arma, municao, agua, comida)
VALUES ('1', '2', '10', '5', '7');
INSERT INTO inventario (rebelde_id, arma, municao, agua, comida)
VALUES ('2', '1', '50', '7', '19');
INSERT INTO inventario (rebelde_id, arma, municao, agua, comida)
VALUES ('3', '4', '19', '10', '10');
INSERT INTO inventario (rebelde_id, arma, municao, agua, comida)
VALUES ('4', '10', '100', '50', '50');
INSERT INTO inventario (rebelde_id, arma, municao, agua, comida)
VALUES ('5', '35', '143', '30', '20');

SELECT * FROM inventario;

-- INNER JOIN
SELECT
  rebelde.id_rebelde,
  rebelde.nome,
  rebelde.localizacao,
  inventario.rebelde_id,
  inventario.arma,
  inventario.municao,
  inventario.agua,
  inventario.comida
FROM rebelde
INNER JOIN inventario
ON inventario.rebelde_id = rebelde.id_rebelde;

-- LEFT JOIN
SELECT
	rebelde.id_rebelde,
  rebelde.nome,
  rebelde.idade,
  inventario.rebelde_id,
  inventario.arma,
  inventario.municao
FROM rebelde
LEFT JOIN inventario
ON inventario.rebelde_id = rebelde.id_rebelde;

-- RIGHT JOIN
SELECT
	rebelde.id_rebelde,
  rebelde.nome,
  rebelde.idade,
  rebelde.localizacao,
  inventario.arma,
  inventario.municao,
  inventario.agua
FROM rebelde
RIGHT JOIN inventario
ON inventario.rebelde_id = rebelde.id_rebelde;

-- FULL JOIN
SELECT
rebelde.id_rebelde,
  rebelde.nome,
  rebelde.idade,
  rebelde.genero,
  rebelde.status,
  rebelde.localizacao,
  inventario.arma,
  inventario.municao,
  inventario.agua,
  inventario.comida
FROM rebelde
FULL JOIN inventario
ON inventario.rebelde_id = rebelde.id_rebelde;