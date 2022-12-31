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
	private Integer id;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	private String nome;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	private String descricao;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	private BigDecimal preco;
	
	@Column
	private Integer quantidade;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	private MarcaModel marca;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	private CategoriaModel categoria;
	
	@Column
	private Boolean produtoVitrine;
	
	@Column
	private Boolean produtoPromocao;
	
	@Column
	private BigDecimal precoPromocional;
	
	@Column
	private Double desconto;
	
	@Column
	private LocalDate dataInicialPromocao;
	
	@Column
	private LocalDate dataFinalPromocao;
	
	@Column
	private byte[] imagem;

}
