DROP TABLE IF EXISTS Estrena;
DROP TABLE IF EXISTS Representacio;
DROP TABLE IF EXISTS Sessio;
DROP TABLE IF EXISTS Local;
DROP TABLE IF EXISTS Espectacle;
DROP TABLE IF EXISTS Entrada;


CREATE TABLE Sessio
(
  sessio character varying(255) NOT NULL,
  CONSTRAINT sessio_pkey PRIMARY KEY (sessio)
);

CREATE TABLE Espectacle
(
  titol character varying(255) NOT NULL,
  participants integer,
  CONSTRAINT espectacle_pkey PRIMARY KEY (titol)
);

CREATE TABLE Local
(
  nom character varying(255) NOT NULL,
  adreca character varying(255),
  CONSTRAINT local_pkey PRIMARY KEY (nom)
);

CREATE TABLE Representacio
(
  noml character varying(255) NOT NULL,
  sessio character varying(255) NOT NULL,
  titole character varying(255) NOT NULL,
  data timestamp without time zone,
  nseientslliures integer,
  preu real,
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
  CONSTRAINT representacio_check CHECK (preu > 0::double precision AND nseientslliures >= 0)
);

CREATE TABLE Estrena
(
  recarrec integer,
  noml character varying(255) NOT NULL,
  sessio character varying(255) NOT NULL,
  CONSTRAINT estrena_pkey PRIMARY KEY (noml, sessio),
  CONSTRAINT fkce3498cc6a820c4 FOREIGN KEY (noml, sessio)
      REFERENCES representacio (noml, sessio) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT estrena_recarrec_check CHECK (recarrec > 0)
);

CREATE TABLE Seient
(
  fila integer NOT NULL,
  columna integer NOT NULL,
  noml character varying(255) NOT NULL,
  CONSTRAINT seient_pkey PRIMARY KEY (fila, columna, noml),
  CONSTRAINT fkce2498cc6a820c2 FOREIGN KEY (noml)
      REFERENCES local (nom) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT seient_check CHECK (fila > 0 AND columna > 0)
);

CREATE TABLE Entrada
(
  idEnt character varying(255) NOT NULL,
  dniClient character varying(255),
  nEspectadors integer,
  data timestamp without time zone,
  preu real,
  sessio character varying(255) NOT NULL,
  noml character varying(255) NOT NULL,
  CONSTRAINT entrada_pkey PRIMARY KEY (idEnt),
  CONSTRAINT fk16128fd04a714c45 FOREIGN KEY (sessio, noml)
      REFERENCES representacio (sessio, noml) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT entrad_check CHECK (preu > 0::double precision AND nEspectadors > 0)
);

CREATE TABLE SeientEnRepresentacio
(
  fila integer NOT NULL,
  columna integer NOT NULL,
  sessio character varying(255) NOT NULL,
  noml character varying(255) NOT NULL,
  estat character varying(255) NOT NULL,
  idEnt character varying(255),
  CONSTRAINT seient_en_representacio_pkey PRIMARY KEY (fila, columna, sessio, noml),
  CONSTRAINT fkce3298cc6a820c2 FOREIGN KEY (sessio, noml)
      REFERENCES representacio (sessio, noml) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkce3298cc6a820c4 FOREIGN KEY (fila, columna, noml)
      REFERENCES seient (fila, columna, noml) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkce3298cc6a820c6 FOREIGN KEY (idEnt)
      REFERENCES entrada (idEnt) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
	

INSERT INTO Sessio VALUES('MATI');
INSERT INTO Sessio VALUES('TARDA');
INSERT INTO Sessio VALUES('NIT');

INSERT INTO Espectacle VALUES('Cisne negro', 10);
INSERT INTO Espectacle VALUES('Lago de los cisnes', 10);
INSERT INTO Espectacle VALUES('Giselle', 10);
INSERT INTO Espectacle VALUES('Romeo y Julieta', 10);
INSERT INTO Espectacle VALUES('Cascanueces', 10);
INSERT INTO Espectacle VALUES('Cenicienta', 10);
INSERT INTO Espectacle VALUES('Don Quijote', 10);
INSERT INTO Espectacle VALUES('La Bella Durmiente', 10);
INSERT INTO Espectacle VALUES('Sueño de una noche de verano', 10);
INSERT INTO Espectacle VALUES('La Bailarina del Templo', 10);

INSERT INTO Local VALUES('Gran Teatre del Liceu', 'Les Rambles, 51-59');
INSERT INTO Local VALUES('Teatre Nacional de Catalunya', 'Plaça de les Arts, 1');
INSERT INTO Local VALUES('Teatro Goya', 'C/ Joaquín Costa, 68');
INSERT INTO Local VALUES('Teatre Lliure de Montjuïc', 'Plaça de Margarida Xirgu, 1');
INSERT INTO Local VALUES('Teatre Victòria', 'Av. del Paral·lel, 67');
INSERT INTO Local VALUES('Teatre Gaudí', 'C/ Sant Antoni Maria Claret, 120');
INSERT INTO Local VALUES('Teatre Lliure de Gràcia', 'C/ del Monseny, 47');
INSERT INTO Local VALUES('Almeria Teatre', 'C/ Sant Lluís, 64');
INSERT INTO Local VALUES('Teatre Club Capitol', 'Les Rambles, 138');

INSERT INTO Representacio VALUES('Gran Teatre del Liceu', 'NIT', 'Cisne negro', '26/01/2016', 100, 50);
INSERT INTO Representacio VALUES('Gran Teatre del Liceu', 'TARDA', 'Cisne negro', '26/01/2016', 100, 50);
INSERT INTO Representacio VALUES('Teatre Nacional de Catalunya', 'MATI', 'Cisne negro', '26/01/2016', 100, 50);
INSERT INTO Representacio VALUES('Gran Teatre del Liceu', 'MATI', 'Cenicienta', '26/01/2016', 100, 50);
INSERT INTO Estrena VALUES(10, 'Gran Teatre del Liceu', 'NIT');
INSERT INTO Estrena VALUES(10, 'Gran Teatre del Liceu', 'TARDA');



INSERT INTO Seient VALUES(1, 1, 'Gran Teatre del Liceu');
INSERT INTO Seient VALUES(1, 2, 'Gran Teatre del Liceu');
INSERT INTO Seient VALUES(1, 3, 'Gran Teatre del Liceu');
INSERT INTO Seient VALUES(1, 4, 'Gran Teatre del Liceu');

INSERT INTO Entrada VALUES(1, '46477890L', 3, '9/01/2016', 10, 'NIT', 'Gran Teatre del Liceu');

INSERT INTO SeientEnRepresentacio VALUES(1, 1, 'NIT', 'Gran Teatre del Liceu', 'OCUPAT', 1);
INSERT INTO SeientEnRepresentacio VALUES(1, 2, 'NIT', 'Gran Teatre del Liceu', 'OCUPAT', 1);
INSERT INTO SeientEnRepresentacio VALUES(1, 3, 'NIT', 'Gran Teatre del Liceu', 'OCUPAT', 1);
INSERT INTO SeientEnRepresentacio VALUES(1, 4, 'NIT', 'Gran Teatre del Liceu', 'LLIURE', NULL);