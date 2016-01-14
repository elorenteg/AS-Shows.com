CREATE FUNCTION crea_seients (nomL text, maxFila int, maxColumna int) RETURNS void AS $$
	BEGIN
		FOR fila IN 1 .. maxFila LOOP
            FOR columna IN 1 .. maxColumna LOOP
	            INSERT INTO Seient VALUES (columna, fila, nomL);
	        END LOOP;
        END LOOP;
	END;
	$$ LANGUAGE plpgsql;
	
CREATE FUNCTION crea_seientsEnRepresentacio (nomL text, maxFila int, maxColumna int) RETURNS void AS $$
	BEGIN
		FOR fila IN 1 .. maxFila LOOP
            FOR columna IN 1 .. maxColumna LOOP
	            INSERT INTO SeientEnRepresentacio VALUES (columna, fila, nomL, 'MATI', 'LLIURE', null),
	            	(columna, fila, nomL, 'TARDA', 'LLIURE', null),
	            	(columna, fila, nomL, 'NIT', 'LLIURE', null);
	        END LOOP;
        END LOOP;
	END;
	$$ LANGUAGE plpgsql;
	
CREATE FUNCTION update_seientsEnRepresentacio (local text, ses text, minFila int, maxFila int, minCol int, maxCol int, id int) RETURNS void AS $$
	BEGIN
		FOR f IN minFila .. maxFila LOOP 
            FOR c IN minCol .. maxCol LOOP
	            UPDATE SeientEnRepresentacio
				SET estat = 'OCUPAT', idEnt = id
				WHERE noml = local AND sessio = ses AND fila = f AND columna = c;
	        END LOOP;
        END LOOP;
	END;
	$$ LANGUAGE plpgsql;