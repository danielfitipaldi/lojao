package br.unit.lojaoDasPecas.controllers;

import br.unit.lojaoDasPecas.entidades.Pedido;
import br.unit.lojaoDasPecas.repository.PedidoDAO;

public class PedidoController {
	
	private PedidoDAO pedidoDao = new PedidoDAO();
	
	public PedidoController() {
		pedidoDao = new PedidoDAO();
	}
	
	public void inserir(Pedido pedido) {
		pedidoDao.inserir(pedido);
	}
	
	
	
}
