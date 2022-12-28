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
	
	public MarcaModel create(MarcaModel marca) {
		return marcaRepository.save(marca);
	}
	
	public List<MarcaModel> readAll() {
		return marcaRepository.findAll();
	}
	
	public List<MarcaModel> findByName(String name) {
		return marcaRepository.findByName(name);
	}
	
	public MarcaModel delete(Integer id) {
		MarcaModel marca = marcaRepository.findById(id).get();
		marcaRepository.delete(marca);
		return marca;
	}
	
	public MarcaModel update(MarcaModel marca) {
		return marcaRepository.save(marca);
	}
}
