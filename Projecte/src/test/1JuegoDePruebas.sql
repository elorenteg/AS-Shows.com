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

INSERT INTO Espectacle VALUES
	('Cisne Negro', 10),
	('Lago de los Cisnes', 10),
	('Giselle', 10),
	('Romeo y Julieta', 10),
	('Cascanueces', 10),
	('Cenicienta', 10),
	('Don Quijote', 10), 
	('La Bella Durmiente', 10),
	('Sueño de una Noche de Verano', 10),
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

INSERT INTO Local VALUES
	('Gran Teatre del Liceu', 'Les Rambles, 51-59'),
	('Teatre Nacional de Catalunya', 'Plaça de les Arts, 1'),
	('Teatro Goya', 'C/ Joaquín Costa, 68'),
	('Teatre Lliure de Montjuïc', 'Plaça de Margarida Xirgu, 1'),
	('Teatre Victòria', 'Av. del Paral·lel, 67'),
	('Teatre Gaudí', 'C/ Sant Antoni Maria Claret, 120'),
	('Teatre Lliure de Gràcia', 'C/ del Monseny, 47'),
	('Almeria Teatre', 'C/ Sant Lluís, 64'),
	('Teatre Club Capitol', 'Les Rambles, 138'),
	('Teatre Coliseum', 'Gran Via de les Corts Catalanes, 595'),
	('Teatre La Villarroel', 'C/ Villarroel, 87'),
	('Joan Teatre Regina', 'C/ Sèneca, 22'),
	('Teatre Tantarantana', 'C/ Flors, 22'),
	('Teatre Romea', 'C/ Hospital, 51'),
	('Teatre Tívoli', 'C/ Casp, 8');

INSERT INTO Representacio VALUES
	('Gran Teatre del Liceu', 'MATI', '26/01/2016', 60, 23, 'Cenicienta'),
	('Gran Teatre del Liceu', 'TARDA', '26/01/2016', 60, 36, 'Cisne Negro'),
	('Gran Teatre del Liceu', 'NIT', '26/01/2016', 60, 44, 'Cisne Negro'),
	('Teatre Nacional de Catalunya', 'MATI', '26/01/2016', 150, 32, 'Cisne Negro'),
	('Teatre Nacional de Catalunya', 'TARDA', '26/01/2016', 150, 32, 'Cenicienta'),
	('Teatre Nacional de Catalunya', 'NIT', '26/01/2016', 150, 42, 'Cenicienta'),
	('Teatre Lliure de Montjuïc', 'MATI', '16/01/2016', 16, 18, 'Cascanueces'),
	('Teatre Lliure de Montjuïc', 'TARDA', '16/01/2016', 16, 24, 'Cenicienta'),
	('Teatre Lliure de Montjuïc', 'NIT', '16/01/2016', 4, 30, 'Don Quijote'),
	('Teatro Goya', 'MATI', '26/01/2016', 100, 25, 'Cisne Negro'),
	('Teatro Goya', 'TARDA', '26/01/2016', 100, 35, 'Cisne Negro'),
	('Teatro Goya', 'NIT', '26/01/2016', 100, 42, 'Cisne Negro'),
	('Teatre Victòria', 'MATI', '26/01/2016', 75, 22, 'Cisne Negro'),
	('Teatre Victòria', 'TARDA', '26/01/2016', 75, 28, 'Cisne Negro'),
	('Teatre Victòria', 'NIT', '26/01/2016', 75, 34, 'Cisne Negro'),
	('Teatre Gaudí', 'MATI', '26/01/2016', 144, 24, 'Cisne Negro'),
	('Teatre Gaudí', 'TARDA', '26/01/2016', 144, 28, 'Cisne Negro'),
	('Teatre Gaudí', 'NIT', '26/01/2016', 144, 32, 'Cisne Negro'),
	('Teatre Lliure de Gràcia', 'MATI', '26/01/2016', 70, 22, 'Cisne Negro'),
	('Teatre Lliure de Gràcia', 'TARDA', '26/01/2016', 70, 22, 'Cisne Negro'),
	('Teatre Lliure de Gràcia', 'NIT', '26/01/2016', 70, 28, 'Cisne Negro'),
	('Almeria Teatre', 'MATI', '26/01/2016', 96, 13, 'Cisne Negro'),
	('Almeria Teatre', 'TARDA', '26/01/2016', 96, 20, 'Don Quijote'),
	('Almeria Teatre', 'NIT', '26/01/2016', 96, 20, 'Don Quijote'),
	('Teatre Club Capitol', 'MATI', '26/01/2016', 165, 18, 'Cisne Negro'),
	('Teatre Club Capitol', 'TARDA', '26/01/2016', 165, 25, 'Cisne Negro'),
	('Teatre Club Capitol', 'NIT', '26/01/2016', 165, 27, 'Cenicienta'),
	('Teatre Coliseum', 'MATI', '26/01/2016', 120, 18, 'Cisne Negro'),
	('Teatre Coliseum', 'TARDA', '26/01/2016', 120, 25, 'Cisne Negro'),
	('Teatre Coliseum', 'NIT', '26/01/2016', 120, 27, 'Cenicienta'),
	('Teatre La Villarroel', 'MATI', '26/01/2016', 120, 18, 'Cenicienta'),
	('Teatre La Villarroel', 'TARDA', '26/01/2016', 120, 25, 'Don Quijote'),
	('Teatre La Villarroel', 'NIT', '26/01/2016', 120, 27, 'Cisne Negro'),
	('Joan Teatre Regina', 'MATI', '26/01/2016', 32, 18, 'Cisne Negro'),
	('Joan Teatre Regina', 'TARDA', '26/01/2016', 32, 25, 'Cisne Negro'),
	('Joan Teatre Regina', 'NIT', '26/01/2016', 32, 27, 'Don Quijote'),
	('Teatre Tantarantana', 'MATI', '26/01/2016', 165, 18, 'Cisne Negro'),
	('Teatre Tantarantana', 'TARDA', '26/01/2016', 165, 25, 'Cenicienta'),
	('Teatre Tantarantana', 'NIT', '26/01/2016', 165, 27, 'Cisne Negro'),
	('Teatre Romea', 'MATI', '26/01/2016', 90, 18, 'Cenicienta'),
	('Teatre Romea', 'TARDA', '26/01/2016', 90, 25, 'Don Quijote'),
	('Teatre Romea', 'NIT', '26/01/2016', 90, 27, 'Don Quijote'),
	('Teatre Tívoli', 'MATI', '26/01/2016', 54, 18, 'Cisne Negro'),
	('Teatre Tívoli', 'TARDA', '26/01/2016', 54, 25, 'Cenicienta'),
	('Teatre Tívoli', 'NIT', '26/01/2016', 54, 27, 'Don Quijote');
	
INSERT INTO Estrena VALUES
	(15, 'Gran Teatre del Liceu', 'NIT'),
	(10, 'Gran Teatre del Liceu', 'TARDA'),
	(10, 'Teatro Goya', 'TARDA'),
	(10, 'Almeria Teatre', 'TARDA'),
	(12.5, 'Teatre Gaudí', 'MATI'),
	(12.5, 'Teatre Gaudí', 'TARDA'),
	(5, 'Teatre Lliure de Gràcia', 'NIT'),
	(5, 'Teatre Lliure de Gràcia', 'TARDA'),
	(8.5, 'Teatre Coliseum', 'TARDA'),
	(10, 'Teatre Romea', 'TARDA'),
	(10, 'Teatre Romea', 'NIT'),
	(12, 'Teatre Tívoli', 'TARDA'),
	(12, 'Teatre Tívoli', 'NIT'),
	(4.5, 'Joan Teatre Regina', 'TARDA'),
	(5.5, 'Teatre La Villarroel', 'NIT');

SELECT crea_seients('Gran Teatre del Liceu', 4, 15);
SELECT crea_seients('Teatre Nacional de Catalunya', 10, 15);
SELECT crea_seients('Teatro Goya', 10, 10);
SELECT crea_seients('Teatre Lliure de Montjuïc', 4, 4);
SELECT crea_seients('Teatre Victòria', 5, 15);
SELECT crea_seients('Teatre Gaudí', 12, 12);
SELECT crea_seients('Teatre Lliure de Gràcia', 7, 10);
SELECT crea_seients('Almeria Teatre', 12, 8);
SELECT crea_seients('Teatre Club Capitol', 11, 15);
SELECT crea_seients('Teatre Coliseum', 10, 12);
SELECT crea_seients('Teatre La Villarroel', 10, 12);
SELECT crea_seients('Joan Teatre Regina', 4, 8);
SELECT crea_seients('Teatre Tantarantana', 11, 15);
SELECT crea_seients('Teatre Romea', 6, 15);
SELECT crea_seients('Teatre Tívoli', 9, 6);

SELECT crea_seientsEnRepresentacio('Gran Teatre del Liceu', 4, 15);
SELECT crea_seientsEnRepresentacio('Teatre Nacional de Catalunya', 10, 15);
SELECT crea_seientsEnRepresentacio('Teatre Lliure de Montjuïc', 4, 4);
SELECT crea_seientsEnRepresentacio('Teatro Goya', 10, 10);
SELECT crea_seientsEnRepresentacio('Teatre Victòria', 5, 15);
SELECT crea_seientsEnRepresentacio('Teatre Gaudí', 12, 12);
SELECT crea_seientsEnRepresentacio('Teatre Lliure de Gràcia', 7, 10);
SELECT crea_seientsEnRepresentacio('Almeria Teatre', 12, 8);
SELECT crea_seientsEnRepresentacio('Teatre Club Capitol', 11, 15);
SELECT crea_seientsEnRepresentacio('Teatre Coliseum', 10, 12);
SELECT crea_seientsEnRepresentacio('Teatre La Villarroel', 10, 12);
SELECT crea_seientsEnRepresentacio('Joan Teatre Regina', 4, 8);
SELECT crea_seientsEnRepresentacio('Teatre Tantarantana', 11, 15);
SELECT crea_seientsEnRepresentacio('Teatre Romea', 6, 15);
SELECT crea_seientsEnRepresentacio('Teatre Tívoli', 9, 6);

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