package br.com.projeto.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.ecommerce.enums.EnumSituacao;
import br.com.projeto.ecommerce.model.MarcaModel;
import br.com.projeto.ecommerce.repository.MarcaRepository;
import jakarta.inject.Inject;

@SpringBootTest
class MarcaServiceTest {

	@Inject
	private MarcaService marcaService;
	
	@Inject
	private MarcaRepository marcaRepository;
	
	@Test
	@DisplayName("Testa criar marca")
	public void testCreateMarca() {
		final var marca = createMarca(1, "Marca", EnumSituacao.ATIVO);
		assertNotNull(marca);
	}
	
	@Test
	@DisplayName("Testa atualizar marca")
	public void testUpdateMarca() {
		var marca = createMarca(1, "Marca", EnumSituacao.ATIVO);
		marca.setName("NovoNome");
		
		marcaService.update(marca);
		assertEquals("NovoNome", marca.getName());	
	}
	
	@Test
	@DisplayName("Testa para buscar marca por nome")
	public void testFindMarcaByName() {
		var marca = createMarca(1, "Marca", EnumSituacao.ATIVO);
		marcaService.findByName(marca.getName());
		
		assertEquals("Marca", marca.getName());
	}
	
	@Test
	@DisplayName("Testa para buscar marca por id")
	public void testFindMarcaById() {
		var marca = createMarca(1, "Marca", EnumSituacao.ATIVO);
		marcaService.findById(marca.getId());
		
		assertEquals(1, marca.getId());
	}
	
	@Test
	@DisplayName("Testa inativar marca")
	public void testInactiveMarca() {
		MarcaModel marca = createMarca(null, "Marca", EnumSituacao.ATIVO);
		marcaService.inactive(marca);
		assertEquals(EnumSituacao.INATIVO, marca.getSituacao());
	}
	
	@Test
	@DisplayName("Testa ativar marca")
	public void testActiveMarca() {
		MarcaModel marca = createMarca(null, "Marca", EnumSituacao.ATIVO);
		marcaService.active(marca);
		assertEquals(EnumSituacao.ATIVO, marca.getSituacao());
	}
	
	private MarcaModel createMarca(Integer id, String nome, EnumSituacao situacao) {
		MarcaModel marca = MarcaModel.builder()
				.id(id)
				.name(nome)
				.situacao(situacao)
				.build();
		marcaRepository.save(marca);
		return marca;
		
	}
}
