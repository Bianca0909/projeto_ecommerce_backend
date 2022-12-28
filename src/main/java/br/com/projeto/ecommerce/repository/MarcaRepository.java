package br.com.projeto.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.ecommerce.model.MarcaModel;


@Repository
public interface MarcaRepository extends JpaRepository<MarcaModel, Integer>  {

	public List<MarcaModel> findByName(String name);
}
