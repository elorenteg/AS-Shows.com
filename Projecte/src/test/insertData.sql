DROP TABLE IF EXISTS Canvis;
DROP TABLE IF EXISTS ShowsCom;
DROP TABLE IF EXISTS SeientEnRepresentacio;
DROP TABLE IF EXISTS Entrada;
DROP TABLE IF EXISTS Estrena;
DROP TABLE IF EXISTS Representacio;
DROP TABLE IF EXISTS Seient;
DROP TABLE IF EXISTS Local;
DROP TABLE IF EXISTS Espectacle;
DROP TABLE IF EXISTS Sessio;

CREATE TABLE Sessio
(
  sessio character varying(255) NOT NULL,
  CONSTRAINT sessio_pkey PRIMARY KEY (sessio)
);

CREATE TABLE Espectacle
(
  titol character varying(255) NOT NULL,
  participants integer,
  CONSTRAINT espectacle_pkey PRIMARY KEY (titol),
  CONSTRAINT espectacle_participants_check CHECK (participants > 0)
);

CREATE TABLE Local
(
  nom character varying(255) NOT NULL,
  adreca character varying(255),
  CONSTRAINT local_pkey PRIMARY KEY (nom)
);

CREATE TABLE Seient
(
  columna integer NOT NULL,
  fila integer NOT NULL,
  noml character varying(255) NOT NULL,
  CONSTRAINT seient_pkey PRIMARY KEY (columna, fila, noml),
  CONSTRAINT fk9362c554e94353e FOREIGN KEY (noml)
      REFERENCES local (nom) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT seient_check CHECK (fila > 0 AND columna > 0)
);

CREATE TABLE Representacio
(
  noml character varying(255) NOT NULL,
  sessio character varying(255) NOT NULL,
  data timestamp without time zone,
  nseientslliures integer,
  preu real,
  titole character varying(255),
  CONSTRAINT representacio_pkey PRIMARY KEY (noml, sessio),
  CONSTRAINT fk26128fd04a714c45 FOREIGN KEY (titole)
      REFERENCES espectacle (titol) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk26128fd0931f615d FOREIGN KEY (sessio)
      REFERENCES sessio (sessio) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk26128fd0e94353e FOREIGN KEY (noml)
      REFERENCES local (nom) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT representacio_sessio_noml_key UNIQUE (sessio, noml),
  CONSTRAINT representacio_sessio_noml_titole_key UNIQUE (sessio, noml, titole),
  CONSTRAINT representacio_check CHECK (preu > 0::double precision AND nseientslliures >= 0)
);

CREATE TABLE Estrena
(
  recarrec integer,
  noml character varying(255) NOT NULL,
  sessio character varying(255) NOT NULL,
  CONSTRAINT estrena_pkey PRIMARY KEY (noml, sessio),
  CONSTRAINT fkce3498cfab7eb9b FOREIGN KEY (noml, sessio)
      REFERENCES representacio (noml, sessio) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT estrena_recarrec_check CHECK (recarrec > 0)
);

CREATE TABLE Entrada
(
  ident character varying(255) NOT NULL,
  data timestamp without time zone,
  dniclient character varying(255),
  nespectadors integer,
  preu real,
  noml character varying(255),
  sessio character varying(255),
  CONSTRAINT entrada_pkey PRIMARY KEY (ident),
  CONSTRAINT fk45afe37fab7eb9b FOREIGN KEY (noml, sessio)
      REFERENCES representacio (noml, sessio) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT entrada_check CHECK (preu > 0::double precision AND nespectadors > 0)
);

CREATE TABLE SeientEnRepresentacio
(
  columna integer NOT NULL,
  fila integer NOT NULL,
  noml character varying(255) NOT NULL,
  sessio character varying(255) NOT NULL,
  estat character varying(255),
  ident character varying(255),
  CONSTRAINT seientenrepresentacio_pkey PRIMARY KEY (columna, fila, noml, sessio),
  CONSTRAINT fkab7a3dd32174544 FOREIGN KEY (columna, fila, noml)
      REFERENCES seient (columna, fila, noml) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkab7a3dd38b44ce3a FOREIGN KEY (ident)
      REFERENCES entrada (ident) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkab7a3dd3fab7eb9b FOREIGN KEY (noml, sessio)
      REFERENCES representacio (noml, sessio) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE ShowsCom
(
  id integer NOT NULL,
  codibanc integer,
  comissio real,
  divisa character varying(255),
  ncompte character varying(255),
  idvenudes integer,
  CONSTRAINT showscom_pkey PRIMARY KEY (id),
  CONSTRAINT showscom_check CHECK (codibanc > 0 AND comissio > 0::double precision)
);

CREATE TABLE canvis
(
  showscom_id integer NOT NULL,
  canvi character varying(255) NOT NULL,
  CONSTRAINT fk77df6270b3be2e27 FOREIGN KEY (showscom_id)
      REFERENCES showscom (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


INSERT INTO Sessio VALUES ('MATI'), ('TARDA'), ('NIT');

INSERT INTO Espectacle VALUES ('Cisne negro', 10),
	('Lago de los cisnes', 10),
	('Giselle', 10),
	('Romeo y Julieta', 10),
	('Cascanueces', 10),
	('Cenicienta', 10),
	('Don Quijote', 10), 
	('La Bella Durmiente', 10),
	('Sueño de una noche de verano', 10),
	('La Bailarina del Templo', 10);

INSERT INTO Local VALUES ('Gran Teatre del Liceu', 'Les Rambles, 51-59'),
	('Teatre Nacional de Catalunya', 'Plaça de les Arts, 1'),
	('Teatro Goya', 'C/ Joaquín Costa, 68'),
	('Teatre Lliure de Montjuïc', 'Plaça de Margarida Xirgu, 1'),
	('Teatre Victòria', 'Av. del Paral·lel, 67'),
	('Teatre Gaudí', 'C/ Sant Antoni Maria Claret, 120'),
	('Teatre Lliure de Gràcia', 'C/ del Monseny, 47'),
	('Almeria Teatre', 'C/ Sant Lluís, 64'),
	('Teatre Club Capitol', 'Les Rambles, 138');

INSERT INTO Representacio VALUES ('Gran Teatre del Liceu', 'MATI', '26/01/2016', 100, 50, 'Cenicienta'),
	('Gran Teatre del Liceu', 'TARDA', '26/01/2016', 100, 50, 'Cisne negro'),
	('Gran Teatre del Liceu', 'NIT', '26/01/2016', 100, 50, 'Cisne negro'),
	('Teatre Nacional de Catalunya', 'MATI', '26/01/2016', 100, 50, 'Cisne negro'),
	('Teatre Nacional de Catalunya', 'TARDA', '26/01/2016', 100, 50, 'Cenicienta'),
	('Teatre Nacional de Catalunya', 'NIT', '26/01/2016', 100, 50, 'Cenicienta');
	
INSERT INTO Estrena VALUES (10, 'Gran Teatre del Liceu', 'NIT'),
	(10, 'Gran Teatre del Liceu', 'TARDA');

SELECT crea_seients('Gran Teatre del Liceu', 11, 15);
SELECT crea_seients('Teatre Nacional de Catalunya', 11, 15);
SELECT crea_seients('Teatro Goya', 11, 15);
SELECT crea_seients('Teatre Lliure de Montjuïc', 11, 15);
SELECT crea_seients('Teatre Victòria', 11, 15);
SELECT crea_seients('Teatre Gaudí', 11, 15);
SELECT crea_seients('Teatre Lliure de Gràcia', 11, 15);
SELECT crea_seients('Almeria Teatre', 11, 15);
SELECT crea_seients('Teatre Club Capitol', 11, 15);

INSERT INTO Entrada VALUES (1, '9/01/2016', '46477890L', 3, 10, 'Gran Teatre del Liceu', 'NIT');

SELECT crea_seientsEnRepresentacio('Gran Teatre del Liceu', 11, 15);
SELECT crea_seientsEnRepresentacio('Teatre Nacional de Catalunya', 11, 15);

INSERT INTO ShowsCom VALUES (1, '2100', '6', 'EUR', 'ES	11	2100	1111	11	11 1111 1111', 1);
INSERT INTO Canvis VALUES (1, 'USD'), (1, 'GBP');