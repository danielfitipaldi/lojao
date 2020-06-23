package br.unit.lojaoDasPecas.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COD_VENDEDOR")
	private Integer codVendedor;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="SALARIO")
	private Double salario;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="vendedor")
	private List <Pedido> pedidos;

}