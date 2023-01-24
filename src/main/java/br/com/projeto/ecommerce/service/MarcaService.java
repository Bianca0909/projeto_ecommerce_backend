package br.com.projeto.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.enums.EnumSituacao;
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
	
	public Optional<MarcaModel> findById(Integer id) {
		return marcaRepository.findById(id);
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
	
	public String inactive(MarcaModel marca) {
		 var marcaEncontrada = marcaRepository.findById(marca.getId()).get();
		 marcaEncontrada.setSituacao(EnumSituacao.INATIVO);
		 marcaRepository.save(marcaEncontrada);
		 return "Marca inativada com sucesso";
	}
	
	public String active(MarcaModel marca) {
		 var marcaEncontrada = marcaRepository.findById(marca.getId()).get();
		 marcaEncontrada.setSituacao(EnumSituacao.ATIVO);
		 marcaRepository.save(marcaEncontrada);
		 return "Marca ativada com sucesso";
	}
}
