package br.unit.lojaoDasPecas.entidades;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="PEDIDO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PEDIDO")
	private Integer idPedido;
	
	@Column(name="QUANTIDADE")
	private Integer quantidade;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="COD_CLIENTE", referencedColumnName = "COD_CLIENTE")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="NOME_PRODUTO", referencedColumnName = "NOME_PRODUTO")
	private Produto produto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COD_VENDEDOR", referencedColumnName = "COD_VENDEDOR")
	private Vendedor vendedor;
	
}
