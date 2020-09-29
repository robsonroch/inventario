package br.com.cbmerj.inventory.services.validation.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.cbmerj.inventory.domain.Cliente;

public class CustomListCliente extends StdSerializer<List<Cliente>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomListCliente() {
		this(null);
	}

	public CustomListCliente(Class<List<Cliente>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Cliente> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		List<Cliente> enderecos = new ArrayList<>();
		for (Cliente item : items) {
			
			enderecos.add(new Cliente(item));
		}
		generator.writeObject(enderecos);
	}
}
