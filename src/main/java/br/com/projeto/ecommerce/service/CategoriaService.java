package br.com.projeto.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.enums.EnumSituacao;
import br.com.projeto.ecommerce.model.CategoriaModel;
import br.com.projeto.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	 
	public CategoriaModel create(CategoriaModel categoria) {
		 categoriaRepository.save(categoria);
		 return categoria;
	}
	
	public List<CategoriaModel> readAll() {
		return categoriaRepository.findAll();
	}
	
	public Optional<CategoriaModel> findById(Integer id) {
		return categoriaRepository.findById(id);
	}
	
	public List<CategoriaModel> findByName(String name) {
		return categoriaRepository.findByName(name);
	}
	
	public String delete(Integer id) {
		CategoriaModel categoria = categoriaRepository.findById(id).get();
		categoriaRepository.delete(categoria);
		return "Categoria excluída com sucesso";
	}
	
	public String update(CategoriaModel categoria) {
		 categoriaRepository.save(categoria);
		 return "Categoria atualizada com sucesso";
	}
	
	public CategoriaModel inactive(CategoriaModel categoria) {
		 categoria.setSituacao(EnumSituacao.INATIVO);
		 categoriaRepository.save(categoria);
		 return categoria;
	}
	
	public String active(CategoriaModel categoria) {
		 categoria.setSituacao(EnumSituacao.ATIVO);
		 categoriaRepository.save(categoria);
		 return "Categoria ativada com sucesso";
	}
}
