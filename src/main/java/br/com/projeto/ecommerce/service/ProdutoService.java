package br.com.projeto.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.ecommerce.model.ProdutoModel;
import br.com.projeto.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public String create(ProdutoModel produto) {
		 produtoRepository.save(produto);
		 return "Produto cadastrado com sucesso";
	}
	
	public List<ProdutoModel> readAll() {
		return produtoRepository.findAll();
	}
	
	public Optional<ProdutoModel> findById(Integer id) {
		return produtoRepository.findById(id);
	}
	
	public List<ProdutoModel> findByNome(String nome) {
		return produtoRepository.findByNome(nome);
	}
	
	public List<ProdutoModel> findByCaracter(String caracter) {
		return produtoRepository.findByCaracter(caracter);
	}
	
	public List<ProdutoModel> findByFavorito() {
		return produtoRepository.findByFavorito();
	}
	
	public String update(ProdutoModel produto) {
		 produtoRepository.save(produto);
		 return "Produto atualizado com sucesso";
	}

}
