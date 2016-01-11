CREATE FUNCTION crea_seients (nomL text, maxFila int, maxColumna int) RETURNS void AS $$
	BEGIN
		FOR fila IN 1 .. maxFila LOOP
            FOR columna IN 1 .. maxColumna LOOP
	            INSERT INTO Seient VALUES (columna, fila, nomL);
	        END LOOP;
        END LOOP;
	END;
	$$ LANGUAGE plpgsql;
	
CREATE FUNCTION crea_seientsEnRepresentacio (nomL text, sessio text, titolE text, idE int, maxFila int, maxColumna int) RETURNS void AS $$
	BEGIN
		FOR fila IN 1 .. maxFila LOOP
            FOR columna IN 1 .. maxColumna LOOP
	            INSERT INTO SeientEnRepresentacio VALUES (columna, fila, nomL, sessio, titolE, 'LLIURE', idE);
	        END LOOP;
        END LOOP;
	END;
	$$ LANGUAGE plpgsql;