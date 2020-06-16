package br.unit.lojaoDasPecas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="VENDEDOR")
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_VENDEDOR")
	private int COD_VENDEDOR;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="RG")
	private String rg;
	
	@Column(name="ENDERECO")
	private String endereco;
}