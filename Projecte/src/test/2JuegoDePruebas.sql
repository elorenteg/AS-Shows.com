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

INSERT INTO Local VALUES ('Gran Teatre del Liceu', 'Les Rambles, 51-59'),
	('Teatre Nacional de Catalunya', 'Plaça de les Arts, 1'),
	('Teatro Goya', 'C/ Joaquín Costa, 68'),
	('Teatre Lliure de Montjuïc', 'Plaça de Margarida Xirgu, 1');

SELECT crea_seients('Gran Teatre del Liceu', 4, 15);
SELECT crea_seients('Teatre Nacional de Catalunya', 10, 15);
SELECT crea_seients('Teatro Goya', 10, 10);
SELECT crea_seients('Teatre Lliure de Montjuïc', 4, 4);

INSERT INTO ShowsCom VALUES (1, '2100', '6', 'EUR', 'ES6600190020961234567890', 1);
INSERT INTO Canvis VALUES (1, 'USD'), (1, 'GBP');
