DROP TABLE IF EXISTS Estrena;
DROP TABLE IF EXISTS Representacio;
DROP TABLE IF EXISTS Sessio;
DROP TABLE IF EXISTS Local;
DROP TABLE IF EXISTS Espectacle;


CREATE TABLE Sessio
(
  sessio character varying(255) NOT NULL,
  CONSTRAINT sessio_pkey PRIMARY KEY (sessio)
);

CREATE TABLE Local
(
  nom character varying(255) NOT NULL,
  adreca character varying(255),
  CONSTRAINT local_pkey PRIMARY KEY (nom)
);

CREATE TABLE Espectacle
(
  titol character varying(255) NOT NULL,
  participants integer,
  CONSTRAINT espectacle_pkey PRIMARY KEY (titol)
);

CREATE TABLE Representacio
(
  noml character varying(255) NOT NULL,
  sessio character varying(255) NOT NULL,
  titole character varying(255) NOT NULL,
  data timestamp without time zone,
  nseientslliures integer,
  preu real,
  CONSTRAINT representacio_pkey PRIMARY KEY (noml, sessio, titole),
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
  CONSTRAINT representacio_check CHECK (preu > 0::double precision AND nseientslliures >= 0)
);

CREATE TABLE Estrena
(
  recarrec integer,
  noml character varying(255) NOT NULL,
  sessio character varying(255) NOT NULL,
  titole character varying(255) NOT NULL,
  CONSTRAINT estrena_pkey PRIMARY KEY (noml, sessio, titole),
  CONSTRAINT fkce3498cc6a820c4 FOREIGN KEY (noml, sessio, titole)
      REFERENCES representacio (noml, sessio, titole) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT estrena_recarrec_check CHECK (recarrec > 0)
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

INSERT INTO Representacio VALUES('Gran Teatre del Liceu', 'MATI', 'Cenicienta', '26/01/2016', 100, 50);
INSERT INTO Representacio VALUES('Gran Teatre del Liceu', 'TARDA', 'Cisne negro', '26/01/2016', 100, 50);
INSERT INTO Representacio VALUES('Gran Teatre del Liceu', 'NIT', 'Cisne negro', '26/01/2016', 100, 50);
INSERT INTO Representacio VALUES('Teatre Nacional de Catalunya', 'MATI', 'Cisne negro', '26/01/2016', 100, 50);
INSERT INTO Representacio VALUES('Teatre Nacional de Catalunya', 'TARDA', 'Cenicienta', '26/01/2016', 100, 50);
INSERT INTO Estrena VALUES(10, 'Gran Teatre del Liceu', 'NIT', 'Cisne negro');
INSERT INTO Estrena VALUES(10, 'Gran Teatre del Liceu', 'TARDA', 'Cisne negro');