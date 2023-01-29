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

import br.com.projeto.ecommerce.model.MarcaModel;
import br.com.projeto.ecommerce.service.MarcaService;

@RequestMapping("/marca")
@RestController
public class MarcaController {

	@Autowired
	MarcaService marcaService;

	@PostMapping
	public String create(@RequestBody MarcaModel marca) {
		return marcaService.create(marca);
	}

	@GetMapping
	public List<MarcaModel> readAll() {
		return marcaService.readAll();
	}
	
	@GetMapping("/find-by-name/{name}")
	public List<MarcaModel> findByName(@PathVariable("name") String name) {
		return marcaService.findByName(name);
	}

	@GetMapping("{id}")
	public Optional<MarcaModel> findById(@PathVariable Integer id) {
		return marcaService.findById(id);
	}
	
//	@DeleteMapping("/{id}")
//	public String delete(@PathVariable Integer id) {
//		return marcaService.delete(id);
//	}

	@PutMapping("/{id}")
	public String update(@RequestBody MarcaModel marca, @PathVariable Integer id) {
		marca.setId(id);
		return marcaService.update(marca);
	}
	
	@PutMapping("/inativar/{id}")
	public String inactive(MarcaModel marca, @PathVariable Integer id) {
		return marcaService.inactive(marca);
	}
	
	@PutMapping("/ativar/{id}")
	public String active(MarcaModel marca, @PathVariable Integer id) {
		return marcaService.active(marca);
	}
}
