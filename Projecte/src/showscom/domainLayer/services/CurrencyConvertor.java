package showscom.domainLayer.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Servei de canvi de divisa per a realitzar el pagament
 */
public class CurrencyConvertor implements Service {
	// nom del servei
	private static final String name = "CurrencyConvertor";

	/**
	 * Consulta el nom del servei
	 * @return nom del servei
	 */
	public String getName() {
		return name;
	}

	/**
	 * Obte la conversio d'una divisa a una altra
	 * @param from divisa que volem canviar
	 * @param to divisa a la que volem canviar
	 * @return conversio de les divises
	 * @throws Exception si no s'ha trobat el servei o la resposta es erronia
	 */
	public float conversorRate(String from, String to) throws Exception {
		try {
			URL url = new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + from + to + "=X&f=l1&e=.cs");
			// URL url2 = new
			// URL("https://www.google.com/finance/converter?a=1&=" + from +
			// "&to=" + to);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			if (line.length() > 0) {
				return Float.parseFloat(line);
			} else
				throw new Exception();
		} catch (IOException | NumberFormatException | NullPointerException e) {
			throw e;
		}
	}
}
