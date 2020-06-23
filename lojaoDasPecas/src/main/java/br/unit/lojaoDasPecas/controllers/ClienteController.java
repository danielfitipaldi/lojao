package br.unit.lojaoDasPecas.controllers;

import java.util.List;

import br.unit.lojaoDasPecas.entidades.Cliente;
import br.unit.lojaoDasPecas.repository.ClienteDAO;

public class ClienteController {
	
	private ClienteDAO clienteDao = new ClienteDAO();
	
	public ClienteController() {
		clienteDao = new ClienteDAO();
	}
	
	public void inserir(Cliente cliente) {
		clienteDao.inserir(cliente);
		
	}
	public void atualizar(Cliente cliente) {
		clienteDao.atualizar(cliente);
	}
	
	public Cliente procurar(String cpf) {
		return clienteDao.procurar(cpf);
	}
	
	public void deletar(Cliente cliente) {
		clienteDao.deletar(cliente);
	}
	
	public List <Cliente> listaClientes() {
		return clienteDao.getClientes();
	}
	
	

}
