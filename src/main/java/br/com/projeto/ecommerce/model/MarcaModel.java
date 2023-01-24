package br.com.projeto.ecommerce.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.projeto.ecommerce.enums.EnumSituacao;
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
@Table(name = "marca")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaModel implements Serializable{

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private EnumSituacao situacao;
}
