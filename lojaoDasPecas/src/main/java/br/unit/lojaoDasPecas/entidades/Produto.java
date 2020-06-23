package br.unit.lojaoDasPecas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="PRODUTO")
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_PRODUTO")
	private Integer codProduto;
	
	@Column(name="NOME_PRODUTO")
	private String nome;
	
	@Column(name="PRECO")
	private Double preco;
	
	@Column(name="QTD_EM_ESTOQUE")
	private Integer estoque;
	
	

}
