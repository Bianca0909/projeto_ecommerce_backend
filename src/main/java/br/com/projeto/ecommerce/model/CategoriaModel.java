package br.com.projeto.ecommerce.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categoria")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaModel implements Serializable{
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotNull
	private String name;

}
