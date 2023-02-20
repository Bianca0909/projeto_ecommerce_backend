package br.com.projeto.ecommerce.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.projeto.ecommerce.enums.EnumSituacao;
import br.com.projeto.ecommerce.model.CategoriaModel;
import br.com.projeto.ecommerce.model.MarcaModel;
import br.com.projeto.ecommerce.model.ProdutoModel;

@SpringBootTest
class ProdutoServiceTest {

	ProdutoService produtoServiceMock = Mockito.mock(ProdutoService.class);
	CategoriaService categoriaServiceMock = Mockito.mock(CategoriaService.class);
	MarcaService marcaServicemock = Mockito.mock(MarcaService.class);

	@Test
	@DisplayName("Testar criar produto")
	public void testCreateProduto() {
		var produto = createProduto(1, "TV", "Tv", BigDecimal.valueOf(4.500), EnumSituacao.ATIVO);
		assertThat(produto).isNotNull();
	}
	
	@Test
	@DisplayName("Testar listar todos os produtos")
	public void testFindAll() {
		List<ProdutoModel> produtoList = new ArrayList<>();
		var produto = createProduto(1, "TV", "Tv", BigDecimal.valueOf(4.500), EnumSituacao.ATIVO);
		produtoList.add(produto);

		when(produtoServiceMock.readAll()).thenReturn(produtoList);
		
		var result = produtoServiceMock.readAll();

		assertThat(result).isEqualTo(produtoList);
	}

	@Test
	@DisplayName("Testa para buscar produto por id")
	public void testFindProdutoById() {
		var produto = createProduto(1, "TV", "Tv", BigDecimal.valueOf(4.500), EnumSituacao.ATIVO);

		produtoServiceMock.findById(produto.getId());
		
		assertThat(produto.getId()).isEqualTo(1);
	}
	
	@Test
	@DisplayName("Testa atualizar produto")
	public void testUpdateProduto() {
		var produto = createProduto(1, "TV", "Tv", BigDecimal.valueOf(4.500), EnumSituacao.ATIVO);
		String nome = "TV 32 polegadas";

		produto.setNome(nome);
		
		produtoServiceMock.update(produto);

		assertThat(produto.getNome()).isEqualTo(nome);
	}
	
	@Test
	@DisplayName("Testa buscar produto por nome")
	public void testFindProdutoByName() {
		List<ProdutoModel> produtoList = new ArrayList<>();
		var produto = createProduto(1, "TV", "Tv", BigDecimal.valueOf(4.500), EnumSituacao.ATIVO);
		
		produtoList.add(produto);

		produtoServiceMock.findByNome(produto.getNome());

		assertThat(produtoList.contains(produto)).isTrue();
	}
	
	@Test
	@DisplayName("Testa buscar produto por caracter")
	public void testFindProdutoByCaracter() {
		List<ProdutoModel> produtoList = new ArrayList<>();
		var primeiroProduto = createProduto(1, "TV", "Tv", BigDecimal.valueOf(4.500), EnumSituacao.ATIVO); 
		var segundoProduto = createProduto(1, "Celular", "Celular", BigDecimal.valueOf(4.500), EnumSituacao.ATIVO);
		
		produtoList.add(primeiroProduto);
		produtoList.add(segundoProduto);
		
		var produtoFilter = produtoServiceMock.findByCaracter("T");
		
		assertThat(produtoFilter.contains(primeiroProduto));
	}
	
	public ProdutoModel createProduto(Integer id, String nome, String descricao, BigDecimal preco,
			EnumSituacao situacao) {

		MarcaModel marca = MarcaModel.builder()
				.id(1)
				.name("Marca")
				.situacao(EnumSituacao.ATIVO)
				.build();

		marcaServicemock.create(marca);

		CategoriaModel categoria = CategoriaModel.builder()
				.id(1)
				.name("Eletrônicos")
				.situacao(EnumSituacao.ATIVO)
				.build();

		categoriaServiceMock.create(categoria);

		ProdutoModel produto = ProdutoModel.builder()
				.id(id)
				.nome(nome)
				.descricao(descricao)
				.preco(preco)
				.marca(marca)
				.categoria(categoria)
				.situacao(situacao)
				.build();
		
		produtoServiceMock.create(produto);

		return produto;
	}

}
