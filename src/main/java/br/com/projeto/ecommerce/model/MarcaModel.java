package br.com.projeto.ecommerce.model;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marca")
@NoArgsConstructor
@Getter
public class MarcaModel implements Serializable{

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Nonnull
	@Column
	private String nome;
	
	public MarcaModel(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}
