package showscom.domainLayer.domainModel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MonedaConverter implements AttributeConverter<String, Moneda> {

	@Override
	public Moneda convertToDatabaseColumn(String value) {
		if (value == null) {
			return null;
		} else
			return Moneda.valueOf(value);
	}

	@Override
	public String convertToEntityAttribute(Moneda moneda) {
		if (moneda == null) {
			return null;
		} else
			return moneda.name();
	}

}
