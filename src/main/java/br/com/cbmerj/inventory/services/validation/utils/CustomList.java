package br.com.cbmerj.inventory.services.validation.utils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.cbmerj.inventory.domain.Categoria;

public class CustomList extends StdSerializer<List> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomList() {
		this(null);
	}

	public CustomList(Class<List> t) {
		super(t);
	}

	@Override
	public void serialize(List items, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		fillList(items);
		
		generator.writeObject(null);
	}

	private void fillList(List items) {
		List<String> nomes = new ArrayList<>();
		Class<?> class1;
		if(!items.isEmpty()) {
			class1 = items.get(0).getClass();
			Constructor<?>[] constructors = class1.getConstructors();
						
			for(Constructor<?> construtor : constructors) {
				Parameter[] parameters = construtor.getParameters();
			}
		}
	}

}