package br.com.projeto.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projeto.ecommerce.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {

	public List<ProdutoModel> findByNome(String nome);
	
	// Dynamic query from JPA
	@Query(value = "SELECT * FROM produto WHERE nome LIKE %?%", nativeQuery = true)
	public List<ProdutoModel> findByCaracter(String caracter);
}
