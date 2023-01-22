package br.com.projeto.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.ecommerce.model.CategoriaModel;
import jakarta.inject.Inject;

@SpringBootTest
public class CategoriaServiceTest{

	@Inject
	private CategoriaService categoriaService;
	
	@Test
	public void testCreate() {
		final var categoria = categoriaService.create(getCategoria());
		assertNotNull(categoria);
	}

	@Test
	public void testUpdate() {
		var categoria = getCategoria();
		categoriaService.create(categoria);
		
		categoria.setName("NovoNome");
		
		categoriaService.update(categoria);
		assertEquals("NovoNome", categoria.getName());	
	}
	
	private CategoriaModel getCategoria() {
		CategoriaModel categoria = CategoriaModel.builder()
				.name("Marca")
				.build();
		return categoria;
	}
}
