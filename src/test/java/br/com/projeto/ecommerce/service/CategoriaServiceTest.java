package br.com.projeto.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.ecommerce.enums.EnumSituacao;
import br.com.projeto.ecommerce.model.CategoriaModel;
import br.com.projeto.ecommerce.repository.CategoriaRepository;
import jakarta.inject.Inject;

@SpringBootTest
public class CategoriaServiceTest{

	@Inject
	private CategoriaService categoriaService;
	
	@Inject 
	private CategoriaRepository categoriaRepository;
	
	@Test
	@DisplayName("Testa criar categoria")
	public void testCreateCategoria() {
		final var categoria = createCategoria(1, "Categoria", EnumSituacao.ATIVO);
		assertNotNull(categoria);
	}

	@Test
	@DisplayName("Testa atualizar categoria")
	public void testUpdateCategoria() {
		var categoria = createCategoria(1, "Categoria", EnumSituacao.ATIVO);
		categoria.setName("NovoNome");
		
		categoriaService.update(categoria);
		assertEquals("NovoNome", categoria.getName());	
	}
	
	@Test
	@DisplayName("Testa para buscar categoria por nome")
	public void testFindCategoriaByName() {
		var categoria = createCategoria(1, "Categoria", EnumSituacao.ATIVO);
		categoriaService.findByName(categoria.getName());
		
		assertEquals("Categoria", categoria.getName());
	}
	
	@Test
	@DisplayName("Testa para buscar categoria por id")
	public void testFindCategoriaById() {
		var categoria = createCategoria(1, "Categoria", EnumSituacao.ATIVO);
		categoriaService.findById(categoria.getId());
		
		assertEquals(1, categoria.getId());
	}
	
	@Test
	@DisplayName("Testa inativar categoria")
	public void testInactiveCategoria() {
		CategoriaModel categoria = createCategoria(null, "Categoria", EnumSituacao.ATIVO);
		categoriaService.inactive(categoria);
		assertEquals(EnumSituacao.INATIVO, categoria.getSituacao());
	}
	
	@Test
	@DisplayName("Testa ativar categoria")
	public void testActiveCategoria() {
		CategoriaModel categoria = createCategoria(null, "Categoria", EnumSituacao.ATIVO);
		categoriaService.active(categoria);
		assertEquals(EnumSituacao.ATIVO, categoria.getSituacao());
	}
	
	private CategoriaModel createCategoria(Integer id, String nome, EnumSituacao situacao) {
		CategoriaModel categoria = CategoriaModel.builder()
				.id(id)
				.name(nome)
				.situacao(situacao)
				.build();
		categoriaRepository.save(categoria);
		return categoria;
		
	}
}
