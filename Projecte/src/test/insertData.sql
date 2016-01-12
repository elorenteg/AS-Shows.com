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