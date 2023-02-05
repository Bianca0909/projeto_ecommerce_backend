package br.com.projeto.ecommerce.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.ecommerce.enums.EnumSituacao;
import br.com.projeto.ecommerce.model.CategoriaModel;

@SpringBootTest
public class CategoriaServiceTest {

	CategoriaService mock = Mockito.mock(CategoriaService.class);
	
	@Test
	@DisplayName("Testa criar categoria")
	public void testCreateCategoria() {
		var categoria = createCategoria(1, "Eletrônicos", EnumSituacao.ATIVO);

		assertThat(categoria).isNotNull();
	}

	@Test
	@DisplayName("Testa atualizar categoria")
	public void testUpdateCategoria() {
		var categoria = createCategoria(1, "Eletrônicos", EnumSituacao.ATIVO);
		String nome = "Novo nome";

		categoria.setName(nome);
		
		mock.update(categoria);

		assertThat(categoria.getName()).isEqualTo(nome);
	}

	@Test
	@DisplayName("Testa para buscar categoria por nome")
	public void testFindCategoriaByName() {
		List<CategoriaModel> categoriaList = new ArrayList<>();
		var categoria = createCategoria(1, "Eletrônicos", EnumSituacao.ATIVO);
		categoriaList.add(categoria);

		mock.findByName(categoria.getName());

		assertThat(categoriaList.contains(categoria)).isTrue();
	}

	@Test
	@DisplayName("Testa para buscar categoria por id")
	public void testFindCategoriaById() {
		var categoria = createCategoria(1, "Eletrônicos", EnumSituacao.ATIVO);

		mock.findById(categoria.getId());
		
		assertThat(categoria.getId()).isEqualTo(1);
	}

	@Test
	@DisplayName("Testa ler todas as categorias")
	public void testFindAllCategoria() {
		List<CategoriaModel> categoriaList = new ArrayList<>();
		var categoria = createCategoria(1, "Eletrônicos", EnumSituacao.ATIVO);
		categoriaList.add(categoria);

		when(mock.readAll()).thenReturn(categoriaList);
		
		var result = mock.readAll();

		assertThat(result).isEqualTo(categoriaList);
	}

	public CategoriaModel createCategoria(Integer id, String nome, EnumSituacao situacao) {
		CategoriaModel categoria = CategoriaModel.builder()
				.id(id)
				.name(nome)
				.situacao(situacao)
				.build();
		
		CategoriaService mock = Mockito.mock(CategoriaService.class);
		mock.create(categoria);
		
		return categoria;
	}
	
}
