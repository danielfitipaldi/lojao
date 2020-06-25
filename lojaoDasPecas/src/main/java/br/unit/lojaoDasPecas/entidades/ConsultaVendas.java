package br.unit.lojaoDasPecas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "uVW_CONSULTA_VENDAS_VENDEDOR")
public class ConsultaVendas {
	
	@Id
	@Column(name="NOME")
	private String nome;
	
	@Column(name="NOME_PRODUTO")
	private String nome_produto;
	
	@Column(name= "QUANTIDADE")
	private Integer quantidade;
	
	@Column(name= "PRECO")
	private Integer preco;

	public String getNome() {
		return nome;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Integer getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return "ConsultaVendas [Nome = " + nome + ", nome_produto=" + nome_produto + ", quantidade=" + quantidade
				+ ", preco=" + preco + "]";
	}
	
	
	
}
