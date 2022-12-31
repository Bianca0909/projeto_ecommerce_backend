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
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.model.ProdutoModel;
import br.com.projeto.ecommerce.service.ProdutoService;

@RequestMapping("/produto")
@RestController
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@PostMapping
	public String create(@RequestBody ProdutoModel produto) {
		return produtoService.create(produto);
	}
	
	@GetMapping
	public List<ProdutoModel> readAll() {
		return produtoService.readAll();
	}
	
	@GetMapping("/find-by-name/{nome}")
	public List<ProdutoModel> findByNome(@PathVariable String nome) {
		return produtoService.findByNome(nome);
	}
	
	@GetMapping("/find-by-caracter/{caracter}")
	public List<ProdutoModel> findByCaracter(@PathVariable String caracter) {
		return produtoService.findByCaracter(caracter);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		return produtoService.delete(id);
	}

	@PutMapping("/{id}")
	public String update(@RequestBody ProdutoModel produto, @PathVariable Integer id) {
		produto.setId(id);
		return produtoService.update(produto);
	}
}
