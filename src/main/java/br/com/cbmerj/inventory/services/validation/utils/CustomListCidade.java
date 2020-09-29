package br.com.cbmerj.inventory.services.validation.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.cbmerj.inventory.domain.Categoria;
import br.com.cbmerj.inventory.domain.Cidade;
import br.com.cbmerj.inventory.domain.Endereco;
import br.com.cbmerj.inventory.domain.Estado;

public class CustomListCidade extends StdSerializer<List<Cidade>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomListCidade() {
		this(null);
	}

	public CustomListCidade(Class<List<Cidade>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Cidade> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		List<Cidade> enderecos = new ArrayList<>();
		for (Cidade item : items) {
			enderecos.add(item);
		}
		generator.writeObject(enderecos);
	}
}