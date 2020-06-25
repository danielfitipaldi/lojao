package br.unit.lojaoDasPecas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="uVW_VL_POR_VENDEDOR")
public class RelatorioVendas {
	
	@Id
	@Column(name="NOME_DO_VENDEDOR")
	private String nomeVendedor;
	
	@Column(name="NOME_DO_PRODUTO")
	private String nomeProduto;
	
	@Column(name="QUANTIDADE_VENDIDA")
	private Integer qtdVendida;
	
	@Column(name="VALOR_TOTAL_POR_VENDA")
	private Double totalVenda;

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Integer getQtdVendida() {
		return qtdVendida;
	}

	public Double getTotalVenda() {
		return totalVenda;
	}

	@Override
	public String toString() {
		return "Relatório de Vendas [ Vendedor = " + nomeVendedor + ", Produto = " + nomeProduto + ", Quantidade = "
				+ qtdVendida + ", Total da venda = " + totalVenda + "]";
	}
	
	

}
