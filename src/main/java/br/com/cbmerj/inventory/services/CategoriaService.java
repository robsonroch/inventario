package br.com.cbmerj.inventory.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.cbmerj.inventory.domain.Categoria;
import br.com.cbmerj.inventory.domain.Cliente;
import br.com.cbmerj.inventory.dto.CategoriaDTO;
import br.com.cbmerj.inventory.dto.ClienteDTO;
import br.com.cbmerj.inventory.repositories.CategoriaRepository;
import br.com.cbmerj.inventory.services.exceptions.DataIntegrityException;
import br.com.cbmerj.inventory.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(CategoriaDTO dto) {
		return repo.save(fromDTO(dto));
	}

	public Categoria update(CategoriaDTO dto) {
		Categoria newObj = find(dto.getId());
		updateData(newObj, fromDTO(dto));
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Existem produtos associados a esta categoria");
		}		
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO dto) {
		return new Categoria(dto);
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
}
