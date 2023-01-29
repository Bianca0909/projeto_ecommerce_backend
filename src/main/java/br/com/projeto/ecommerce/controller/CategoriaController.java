package br.com.projeto.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.ecommerce.model.CategoriaModel;
import br.com.projeto.ecommerce.service.CategoriaService;

@RequestMapping("/categoria")
@RestController
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	@PostMapping
	public String create(@RequestBody CategoriaModel categoria) {
		return categoriaService.create(categoria);
	}
	
	@GetMapping
	public List<CategoriaModel> readAll() {
		return categoriaService.readAll();
	}
	
	@GetMapping("/find-by-name/{name}")
	public List<CategoriaModel> findByName(@PathVariable("name") String name) {
		return categoriaService.findByName(name);
	}
	
	@GetMapping("{id}")
	public Optional<CategoriaModel> findById(@PathVariable Integer id) {
		return categoriaService.findById(id);
	}
	
//	@DeleteMapping("/{id}")
//	public String delete(@PathVariable Integer id) {
//		return categoriaService.delete(id);
//	}
	
	@PutMapping("/{id}")
	public String update(@RequestBody CategoriaModel categoria, @PathVariable Integer id) {
		categoria.setId(id);
		return categoriaService.update(categoria);
	}
	
	@PutMapping("/inativar/{id}")
	public String inactive(CategoriaModel categoria, @PathVariable Integer id) {
		return categoriaService.inactive(categoria);
	}
	
	@PutMapping("/ativar/{id}")
	public String active(CategoriaModel categoria, @PathVariable Integer id) {
		return categoriaService.active(categoria);
	}
}
