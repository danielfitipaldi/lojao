package br.unit.lojaoDasPecas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Table(name = "uVW_CONSULTA_PRODUTOS")
public class ConsultaProduto {


@Column
@Id
private String NOME_PRODUTO;

@Column(name="QTD_EM_ESTOQUE")
private Integer quantidade;

public String getNOME_PRODUTO() {
	return NOME_PRODUTO;
}

public Integer getQuantidade() {
	return quantidade;
}


@Override
public String toString() {
	return "ConsultaProduto [NOME_PRODUTO=" + NOME_PRODUTO + ", Quantidade em estoque =" + quantidade + "]";
}



}