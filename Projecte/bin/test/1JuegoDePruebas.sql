DELETE FROM Canvis;
DELETE FROM ShowsCom;
DELETE FROM SeientEnRepresentacio;
DELETE FROM Entrada;
DELETE FROM Estrena;
DELETE FROM Representacio;
DELETE FROM Seient;
DELETE FROM Local;
DELETE FROM Espectacle;
DELETE FROM Sessio;

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
	('La Bailarina del Templo', 10),
	('El Cascanueces', 10),
	('Coppélia', 10),
	('La Sylphide', 10),
	('La Bayadère', 10),
	('Sylvia', 10),
	('El Pájaro de Fuego', 10),
	('Llamas de París', 10),
	('Talismán', 10),
	('El Corsario', 10),
	('La Hija del Faraón', 10),
	('Petrouchka', 10);

INSERT INTO Local VALUES ('Gran Teatre del Liceu', 'Les Rambles, 51-59'),
	('Teatre Nacional de Catalunya', 'Plaça de les Arts, 1'),
	('Teatro Goya', 'C/ Joaquín Costa, 68'),
	('Teatre Lliure de Montjuïc', 'Plaça de Margarida Xirgu, 1'),
	('Teatre Victòria', 'Av. del Paral·lel, 67'),
	('Teatre Gaudí', 'C/ Sant Antoni Maria Claret, 120'),
	('Teatre Lliure de Gràcia', 'C/ del Monseny, 47'),
	('Almeria Teatre', 'C/ Sant Lluís, 64'),
	('Teatre Club Capitol', 'Les Rambles, 138');

INSERT INTO Representacio VALUES ('Gran Teatre del Liceu', 'MATI', '26/01/2016', 60, 23, 'Cenicienta'),
	('Gran Teatre del Liceu', 'TARDA', '26/01/2016', 60, 36, 'Cisne negro'),
	('Gran Teatre del Liceu', 'NIT', '26/01/2016', 60, 44, 'Cisne negro'),
	('Teatre Nacional de Catalunya', 'MATI', '26/01/2016', 150, 32, 'Cisne negro'),
	('Teatre Nacional de Catalunya', 'TARDA', '26/01/2016', 150, 32, 'Cenicienta'),
	('Teatre Nacional de Catalunya', 'NIT', '26/01/2016', 150, 42, 'Cenicienta'),
	('Teatre Lliure de Montjuïc', 'MATI', '16/01/2016', 16, 18, 'Cascanueces'),
	('Teatre Lliure de Montjuïc', 'TARDA', '16/01/2016', 16, 24, 'Cenicienta'),
	('Teatre Lliure de Montjuïc', 'NIT', '16/01/2016', 4, 30, 'Don Quijote');
	
INSERT INTO Estrena VALUES (15, 'Gran Teatre del Liceu', 'NIT'),
	(10, 'Gran Teatre del Liceu', 'TARDA');

SELECT crea_seients('Gran Teatre del Liceu', 4, 15);
SELECT crea_seients('Teatre Nacional de Catalunya', 10, 15);
SELECT crea_seients('Teatro Goya', 10, 10);
SELECT crea_seients('Teatre Lliure de Montjuïc', 4, 4);
SELECT crea_seients('Teatre Victòria', 15, 5);
SELECT crea_seients('Teatre Gaudí', 12, 12);
SELECT crea_seients('Teatre Lliure de Gràcia', 7, 10);
SELECT crea_seients('Almeria Teatre', 12, 8);
SELECT crea_seients('Teatre Club Capitol', 11, 15);

SELECT crea_seientsEnRepresentacio('Gran Teatre del Liceu', 4, 15);
SELECT crea_seientsEnRepresentacio('Teatre Nacional de Catalunya', 10, 15);
SELECT crea_seientsEnRepresentacio('Teatre Lliure de Montjuïc', 4, 4);

INSERT INTO Entrada VALUES (1, '9/01/2016', '38477456C', 4, 144, 'Teatre Lliure de Montjuïc', 'NIT');
INSERT INTO Entrada VALUES (2, '12/01/2016', '28447486M', 8, 288, 'Teatre Lliure de Montjuïc', 'NIT');

UPDATE SeientEnRepresentacio
SET estat='OCUPAT', idEnt=1
WHERE noml='Teatre Lliure de Montjuïc' AND sessio='NIT'
AND fila=2;

UPDATE SeientEnRepresentacio
SET estat='OCUPAT', idEnt=2
WHERE noml='Teatre Lliure de Montjuïc' AND sessio='NIT'
AND fila IN (3,4);

INSERT INTO ShowsCom VALUES (1, '2100', '6', 'EUR', 'ES6600190020961234567890', 3);
INSERT INTO Canvis VALUES (1, 'USD'), (1, 'GBP');