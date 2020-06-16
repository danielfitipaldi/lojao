package br.unit.lojaoDasPecas.controllers;

import java.util.List;

import br.unit.lojaoDasPecas.entidades.Vendedor;
import br.unit.lojaoDasPecas.repository.VendedorDAO;

public class VendedorController {
	
	private VendedorDAO vendedorDao = new VendedorDAO();
	
	public VendedorController() {
		vendedorDao = new VendedorDAO();
	}
	
	public boolean inserir(Vendedor vendedor) {
		vendedorDao.inserir(vendedor);
		return true;
	}
	public void atualizar(Vendedor vendedor) {
		vendedorDao.atualizar(vendedor);
	}
	
	public Vendedor procurar(String cpf) {
		return vendedorDao.procurar(cpf);
	}
	
	public void deletar(Vendedor vendedor) {
		vendedorDao.deletar(vendedor);
	}
	
	public List <Vendedor> listaVendedores() {
		return vendedorDao.getVendedores();
	}


}
