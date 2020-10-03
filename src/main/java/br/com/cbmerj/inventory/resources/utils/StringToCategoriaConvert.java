package br.com.cbmerj.inventory.resources.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import br.com.cbmerj.inventory.domain.Categoria;
import br.com.cbmerj.inventory.repositories.CategoriaRepository;

//public class StringToCategoriaConvert implements Converter<List<Integer>, List<Categoria>> {
//	
//	@Autowired
//	private CategoriaRepository categoriaRepository;
//	
//	@Override
//	public List<Categoria> convert(List<Integer> categoriaIds) {
//		
//		try {
//			if (!categoriaIds.isEmpty()) {
//				
//				return categoriaRepository.findAllById(categoriaIds);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//}
