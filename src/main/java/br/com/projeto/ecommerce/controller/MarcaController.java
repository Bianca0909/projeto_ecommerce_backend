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
import br.com.projeto.ecommerce.service.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	MarcaService marcaService;

	@PostMapping
	public MarcaModel create(@RequestBody MarcaModel marca) {
		return marcaService.create(marca);
	}

	@GetMapping
	public List<MarcaModel> readAll() {
		return marcaService.readAll();
	}

	@DeleteMapping("/{id}")
	public MarcaModel delete(@PathVariable("id") Integer id) {
		return marcaService.delete(id);
	}

	@PutMapping
	public MarcaModel update(@RequestBody MarcaModel marca, @RequestParam("id") Integer id) {
		return marcaService.update(marca);
	}
}
