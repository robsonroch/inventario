package br.com.cbmerj.inventory.services.validation.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.cbmerj.inventory.domain.Endereco;

public class CustomListEndereco extends StdSerializer<List<Endereco>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomListEndereco() {
		this(null);
	}

	public CustomListEndereco(Class<List<Endereco>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Endereco> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		List<Endereco> enderecos = new ArrayList<>();
		for (Endereco item : items) {
			
			enderecos.add(new Endereco(item));
		}
		generator.writeObject(enderecos);
	}
}