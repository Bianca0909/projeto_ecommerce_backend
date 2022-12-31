package br.com.projeto.ecommerce.service;

import java.util.List;

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
	
	public List<ProdutoModel> findByNome(String nome) {
		return produtoRepository.findByNome(nome);
	}
	
	public List<ProdutoModel> findByCaracter(String caracter) {
		return produtoRepository.findByCaracter(caracter);
	}
	
	public String delete(Integer id) {
		ProdutoModel produto = produtoRepository.findById(id).get();
		produtoRepository.delete(produto);
		return "Produto excluído com sucesso";
	}
	
	public String update(ProdutoModel produto) {
		 produtoRepository.save(produto);
		 return "Produto atualizado com sucesso";
	}
}
