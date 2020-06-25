package br.unit.lojaoDasPecas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="uVW_PRODUTO_MAIS_VENDIDO")
public class MaisVendidos {
	
	
	@Id
	@Column(name="QUANTIDADE_VENDIDA")
	private Integer quantidade;
	
	@Column(name="NOME_DO_PRODUTO")
	private String nome;
	
	@Column(name="VALOR_UNITARIO")
	private Double preco;
	
	@Column(name="TOTAL_POR_PRODUTO")
	private Double total;

	public Integer getQuantidade() {
		return quantidade;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}

	public Double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "Produtos mais vendidos [Nome do Produto = " + nome + ", Quantidade = " + quantidade + ", Preço = " + preco + ", Valor Total = " + total
				+ "]";
	}
	
	

}
