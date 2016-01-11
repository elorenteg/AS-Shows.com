package showscom.domainLayer.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class CurrencyConvertor implements Service {
	private static final String name = "CurrencyConvertor";

	public String getName() {
		return name;
	}

	public float conversorRate(String from, String to) {
		try {
			URL url = new URL("http://download.finance.yahoo.com/d/quotes.csv?s=" + from + to + "=X&f=l1&e=.cs");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			if (line.length() > 0) {
				return Float.parseFloat(line);
			}
			reader.close();
		} catch (IOException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		return 0;
	}
}
