package br.com.projeto.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.projeto.ecommerce.enums.EnumSituacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotNull(message = "O campo nome não pode ser nulo")
	private String nome;
	
	@Column
	@NotNull(message = "O campo descrição não pode ser nulo")
	private String descricao;
	
	@Column
	@NotNull(message = "O campo preço não pode ser nulo")
	private BigDecimal preco;

	@JoinColumn(name = "marca", referencedColumnName = "id")
	@NotNull(message = "O campo marca não pode ser nulo")
	@ManyToOne
	private MarcaModel marca;

	@JoinColumn(name = "categoria", referencedColumnName = "id")
	@NotNull(message = "O campo categoria não pode ser nulo")
	@ManyToOne
	private CategoriaModel categoria;
	
	@Column
	@NotNull(message = "O campo situação não pode ser nulo")
	private EnumSituacao situacao;
	
	@Column
	private Integer quantidade;
	
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
	private String imagem;
	
	@Column
	private Boolean favorito;

}
