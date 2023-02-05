package br.com.projeto.ecommerce.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.ecommerce.enums.EnumSituacao;
import br.com.projeto.ecommerce.model.MarcaModel;

@SpringBootTest
class MarcaServiceTest {

	MarcaService mock = Mockito.mock(MarcaService.class);

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
		String nome = "Novo nome";
		
		marca.setName(nome);
		
		mock.update(marca);
		
		assertThat(marca.getName()).isEqualTo(nome);
	}
	
	@Test
	@DisplayName("Testa para buscar marca por nome")
	public void testFindMarcaByName() {
		List<MarcaModel> marcaList = new ArrayList<>(); 
		var marca = createMarca(1, "Marca", EnumSituacao.ATIVO);
		marcaList.add(marca);
		
		mock.findByName(marca.getName());
		assertThat(marcaList.contains(marca)).isTrue();
	}
	
	@Test
	@DisplayName("Testa para buscar marca por id")
	public void testFindMarcaById() {
		var marca = createMarca(1, "Marca", EnumSituacao.ATIVO);
		
		mock.findById(marca.getId());
		
		assertThat(marca.getId()).isEqualTo(1);
	}
	
	@Test
	public void testFindAllMarca() {
		List<MarcaModel> marcaList = new ArrayList<>();
		var marca = createMarca(1, "Marca", EnumSituacao.ATIVO);
		marcaList.add(marca);
		
		when(mock.readAll()).thenReturn(marcaList);
		
		var result = mock.readAll();

		assertThat(result).isEqualTo(marcaList);
	}
	
	private MarcaModel createMarca(Integer id, String nome, EnumSituacao situacao) {
		MarcaModel marca = MarcaModel.builder()
				.id(id)
				.name(nome)
				.situacao(situacao)
				.build();
		
		mock.create(marca);
		
		return marca;
	}
	
}
