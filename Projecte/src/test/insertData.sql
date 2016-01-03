
DELETE FROM Estrena;
DELETE FROM Representacio;
DELETE FROM Sessio;
DELETE FROM Espectacle;
DELETE FROM Local;

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

INSERT INTO Representacio VALUES('Gran Teatre del Liceu', 'NIT', 'Cisne negro', '26/01/2016', 100, 50, 'Gran Teatre del Liceu', 'NIT');
INSERT INTO Representacio VALUES('Gran Teatre del Liceu', 'TARDA', 'Cisne negro', '26/01/2016', 100, 50, 'Gran Teatre del Liceu', 'TARDA');
INSERT INTO Representacio VALUES('Teatre Nacional de Catalunya', 'MATI', 'Cisne negro', '26/01/2016', 100, 50, 'Teatre Nacional de Catalunya', 'MATI');
INSERT INTO Representacio VALUES('Gran Teatre del Liceu', 'MATI', 'Cenicienta', '26/01/2016', 100, 50, 'Gran Teatre del Liceu', 'NIT');
INSERT INTO Estrena VALUES(10, 'Gran Teatre del Liceu', 'NIT', 'Cisne negro');
INSERT INTO Estrena VALUES(10, 'Gran Teatre del Liceu', 'TARDA', 'Cisne negro');