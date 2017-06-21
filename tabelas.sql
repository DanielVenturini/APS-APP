DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS refeicao;
DROP TABLE IF EXISTS reajuste;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS tipo;

CREATE TABLE cargo
(
  id SERIAL NOT NULL,
  nome character varying(30),
  CONSTRAINT cargo_pkey PRIMARY KEY (id)
);

CREATE TABLE funcionario
(
  id SERIAL NOT NULL,
  nome character varying(40),
  id_cargo integer,
  CONSTRAINT funcionario_pkey PRIMARY KEY (id),
  CONSTRAINT funcionario_id_cargo_fkey FOREIGN KEY (id_cargo)
      REFERENCES cargo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE tipo
(
  id SERIAL NOT NULL,
  nome character varying(25),
  CONSTRAINT tipo_pkey PRIMARY KEY (id)
);

CREATE TABLE usuario
(
  ra integer NOT NULL,
  senha character varying(8),
  nome character varying(40),
  tipo integer,
  foto character varying(256),
  CONSTRAINT usuario_pkey PRIMARY KEY (ra),
  CONSTRAINT usuario_tipo_fkey FOREIGN KEY (tipo)
      REFERENCES tipo (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE reajuste
(
  id SERIAL NOT NULL,
  data date,
  valor double precision,
  obs character varying(256),
  CONSTRAINT reajuste_pkey PRIMARY KEY (id)
);

CREATE TABLE refeicao
(
  id SERIAL NOT NULL,
  "timestamp" character varying(15),
  ra integer,
  saldo double precision,
  quantidade integer,
  idreajuste integer,
  CONSTRAINT refeicao_pkey PRIMARY KEY (id),
  CONSTRAINT refeicao_idreajuste_fkey FOREIGN KEY (idreajuste)
      REFERENCES reajuste (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT refeicao_ra_fkey FOREIGN KEY (ra)
      REFERENCES usuario (ra) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);