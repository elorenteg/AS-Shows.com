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
  titole character varying(255) NOT NULL,
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
  CONSTRAINT showscom_check CHECK (codibanc > 0 AND comissio > 0::double precision AND id = 1)
);

CREATE TABLE canvis
(
  showscom_id integer NOT NULL,
  canvi character varying(255) NOT NULL,
  CONSTRAINT fk77df6270b3be2e27 FOREIGN KEY (showscom_id)
      REFERENCES showscom (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
