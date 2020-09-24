package br.com.cbmerj.inventory.services.validation.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.cbmerj.inventory.domain.Categoria;

public class CustomListSerializer extends StdSerializer<List<Categoria>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomListSerializer() {
		this(null);
	}

	public CustomListSerializer(Class<List<Categoria>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Categoria> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		List<String> nomes = new ArrayList<>();
		for (Categoria item : items) {
			nomes.add(item.getNome());
		}
		generator.writeObject(nomes);
	}
}