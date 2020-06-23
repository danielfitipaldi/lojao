package br.unit.lojaoDasPecas.view;

import java.util.Scanner;

import br.unit.lojaoDasPecas.controllers.PedidoController;
import br.unit.lojaoDasPecas.entidades.Pedido;
import br.unit.lojaoDasPecas.repository.ClienteDAO;



public class PedidoView extends ClienteView{
	Scanner leTeclado = new Scanner(System.in);
	
	public Pedido registrarPedido() {
		PedidoController pedidoController = new PedidoController();
		Pedido pedido = new Pedido();
		
		pedido.setCliente(cadastrarCliente());
		pedido.setProduto(produto);
		pedido.setVendedor(vendedor);
		
	}
	
	
		
	
}


