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
@Table(name="CLIENTE")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable{

	private static final long serialVersionUID = -8695866440001367831L;
	
	@Id
	@Column(name="COD_CLIENTE")
	private int COD_CLIENTE;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="RG")
	private String rg;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	

}