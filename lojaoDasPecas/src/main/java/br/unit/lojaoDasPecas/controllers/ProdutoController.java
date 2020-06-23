package br.unit.lojaoDasPecas.controllers;

import java.util.List;

import br.unit.lojaoDasPecas.entidades.Produto;
import br.unit.lojaoDasPecas.repository.ProdutoDAO;

public class ProdutoController {
	
	private ProdutoDAO produtoDao = new ProdutoDAO();
	
	public ProdutoController() {
		produtoDao = new ProdutoDAO();
	}
	
	public boolean inserir(Produto produto) {
		produtoDao.inserir(produto);
		return true;
	}
	public void editar(Produto produto) {
		produtoDao.editar(produto);
	}
	
	public Produto procurar(String nome) {
		return produtoDao.procurar(nome);
	}
	
	public void deletar(Produto produto) {
		produtoDao.deletar(produto);
	}
	
	public List <Produto> listaProdutos() {
		return produtoDao.getProdutos();
	}
}
