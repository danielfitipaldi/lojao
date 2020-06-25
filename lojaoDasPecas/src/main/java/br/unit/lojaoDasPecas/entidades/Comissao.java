package br.unit.lojaoDasPecas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="VIEW uVW_COMISSAO_VENDEDOR ")
public class Comissao {
	
	@Id
	@Column(name="NOME_DO_VENDEDOR")
	private String nomeVendedor;
	
	@Column(name="SALARIO_DO_VENDEDOR")
	private Double salarioVendedor;
	
	@Column(name="COMISSAO_DO_VENDEDOR")
	private Double comissaoVendedor;

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public Double getSalarioVendedor() {
		return salarioVendedor;
	}

	public Double getComissaoVendedor() {
		return comissaoVendedor;
	}

	@Override
	public String toString() {
		return "Comissao [nomeVendedor=" + nomeVendedor + ", salarioVendedor=" + salarioVendedor + ", comissaoVendedor="
				+ comissaoVendedor + "]";
	}
	
	

}
