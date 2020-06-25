package br.unit.lojaoDasPecas.controllers;

import java.util.List;

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
	public List <Pedido> listaPedidos() {
		return pedidoDao.listarPedidos();
	}
	public void atualizar(Pedido pedido) {
		pedidoDao.editar(pedido);
	}
	public Pedido procurar(Integer idPedido) {
		return pedidoDao.procurar(idPedido);
	}
	public void deletar(Pedido pedido) {
		pedidoDao.deletar(pedido);
	}
	
	
}
