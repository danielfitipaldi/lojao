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
@Table(name="CLIENTE")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable{

	private static final long serialVersionUID = -8695866440001367831L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_CLIENTE")
	private Integer codCliente;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="CIDADE")
	private String cidade;
	
	

}