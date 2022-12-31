package br.com.projeto.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.model.MarcaModel;
import br.com.projeto.ecommerce.repository.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;
	
	public String create(MarcaModel marca) {
		 marcaRepository.save(marca);
		 return "Marca cadastrada com sucesso";
	}
	
	public List<MarcaModel> readAll() {
		return marcaRepository.findAll();
	}
	
	public List<MarcaModel> findByName(String name) {
		return marcaRepository.findByName(name);
	}
	
	public String delete(Integer id) {
		MarcaModel marca = marcaRepository.findById(id).get();
		marcaRepository.delete(marca);
		return "Marca excluída com sucesso";
	}
	
	public String update(MarcaModel marca) {
		 marcaRepository.save(marca);
		 return "Marca atualizada com sucesso";
	}
	
}
