package br.unit.lojaoDasPecas;

import java.util.List;

import br.unit.lojaoDasPecas.entidades.Cliente;
import br.unit.lojaoDasPecas.entidades.Vendedor;
import br.unit.lojaoDasPecas.repository.ClienteDAO;
import br.unit.lojaoDasPecas.repository.VendedorDAO;
import br.unit.lojaoDasPecas.view.*;

public class App 
{
	public static void main(String[] args) {
    	VendedorDAO vendedorDao = new VendedorDAO();
    	
    	Vendedor vendedor = new Vendedor(1, "Joana", "123", "456", "Rua tal");
    	vendedorDao.getVendedor(vendedor);
    	
    	List < Vendedor > vendedores = vendedorDao.getVendedores();
    	for (Vendedor vendedor1 : vendedores) {
    		System.out.println(vendedor1);
    	}
    	
    	ClienteDAO clienteDao = new ClienteDAO();

		/*Cliente cliente = new Cliente(1, "Daniel", 123, "456", "Rua tal");
		clienteDao.inserir(cliente);

		Cliente cliente2 = new Cliente(2, "João", 789, "1011", "Rua Qual");
		clienteDao.inserir(cliente2);

		Cliente cliente3 = new Cliente(3, "Amanda", 1213, "1415", "Rua tanto");
		clienteDao.inserir(cliente3);*/
    	
    	//Cliente cliente = new Cliente(cadastrarCliente());

		List<Cliente> listaClientes = clienteDao.getClientes();
		for (Cliente clientes : listaClientes) {
			System.out.println(clientes);
		}
    	
    }
}