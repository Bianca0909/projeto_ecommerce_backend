package br.com.projeto.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.model.MarcaModel;
import br.com.projeto.ecommerce.model.ProdutoModel;
import br.com.projeto.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@PostMapping
	public ProdutoModel create(@RequestBody ProdutoModel produto) {
		return produtoService.create(produto);
	}
	
	@GetMapping
	public List<ProdutoModel> readAll() {
		return produtoService.readAll();
	}
	
	@GetMapping("/find-by-name/{name}")
	public List<ProdutoModel> findByNome(@PathVariable("name") String nome) {
		return produtoService.findByNome(nome);
	}

	@DeleteMapping
	public String delete(@PathVariable("id") Integer id) {
		return produtoService.delete(id);
	}

	@PutMapping
	public ProdutoModel update(@RequestBody ProdutoModel produto, @RequestParam("id") Integer id) {
		produto.setId(id);
		return produtoService.update(produto);
	}
}
