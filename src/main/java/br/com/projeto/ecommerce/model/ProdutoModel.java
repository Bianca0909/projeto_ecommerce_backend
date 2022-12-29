package br.com.projeto.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel implements Serializable {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	String nome;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	String descricao;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	BigDecimal preco;
	
	@Column
	Integer quantidade;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	MarcaModel marca;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	CategoriaModel categoria;
	
	@Column
	Boolean produtoVitrine;
	
	@Column
	Boolean produtoPromocao;
	
	@Column
	BigDecimal precoPromocional;
	
	@Column
	Double desconto;
	
	@Column
	LocalDate dataInicialPromocao;
	
	@Column
	LocalDate dataFinalPromocao;
	
	@Column
	byte[] imagem;

}
