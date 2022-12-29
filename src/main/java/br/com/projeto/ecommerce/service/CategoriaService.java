package br.com.projeto.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.model.CategoriaModel;
import br.com.projeto.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public CategoriaModel create(CategoriaModel categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<CategoriaModel> readAll() {
		return categoriaRepository.findAll();
	}
	
	public List<CategoriaModel> findByName(String name) {
		return categoriaRepository.findByName(name);
	}
	
	public CategoriaModel delete(Integer id) {
		CategoriaModel categoria = categoriaRepository.findById(id).get();
		categoriaRepository.delete(categoria);
		return categoria;
	}
	
	public CategoriaModel update(CategoriaModel categoria) {
		return categoriaRepository.save(categoria);
	}
}
