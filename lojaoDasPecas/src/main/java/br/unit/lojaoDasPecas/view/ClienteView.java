package br.unit.lojaoDasPecas.view;

import java.util.List;
import java.util.Scanner;

import br.unit.lojaoDasPecas.controllers.ClienteController;
import br.unit.lojaoDasPecas.entidades.Cliente;
import br.unit.lojaoDasPecas.exception.ClienteException;


public class ClienteView {
	Scanner leTeclado = new Scanner(System.in);

	public Cliente cadastrarCliente() {

		System.out.println("Por favor, digite o seu CPF: ");
		String cpf = leTeclado.next();
		ClienteController clienteController = new ClienteController();
		Cliente cliente = clienteController.procurar(cpf);
		if (cliente == null) {
			System.out.println("Nome: ");
			String nome = leTeclado.next();
			leTeclado.nextLine();

			System.out.println("Cidade: ");
			String cidade = leTeclado.next();
			leTeclado.nextLine();

			Cliente novoCliente = new Cliente(null, nome, cpf, cidade);
			clienteController.inserir(novoCliente);
			return novoCliente;
			
		} else {
			System.out.println("Cliente já cadastrado: " + cliente.getNome());
			throw new ClienteException("Cliente já cadastrado");
		}
	}

	public void editarCadastro() {

		ClienteController clienteController = new ClienteController();
		Cliente cliente = new Cliente();

		System.out.println("EDITAR CLIENTE");
		System.out.println("Digite o CPF da pessoa a ter sua conta alterada: ");
		String cpf = leTeclado.next();
		leTeclado.nextLine();
		cliente = clienteController.procurar(cpf);
		if (cliente == null) {
			throw new ClienteException("Cliente não localizado");
		}
		
		System.out.println("Nome do cliente: " + cliente.getNome());
		System.out.println("O que deseja alterar? [ 1 ] Nome do Cliente \n"
				+ "[ 2 ] Cidade");
		int opcao = leTeclado.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Digite o novo nome");
			String nome = leTeclado.next();
			leTeclado.nextLine();
			cliente.setNome(nome);
			clienteController.atualizar(cliente);
			System.out.println("Atualização concluída");
			break;
		case 2:
			System.out.print("Digite a nova Cidade: ");
			String cidade = leTeclado.next();
			leTeclado.nextLine();
			cliente.setCidade(cidade);
			clienteController.atualizar(cliente);
			System.out.println("Atualização concluída");
			break;
		}

	}
	
	public static void listarClientes() {
		ClienteController clienteController = new ClienteController();
		List<Cliente> clientes = clienteController.listaClientes();
		clientes.forEach(System.out::println);
		
	}
	
	public void deletarCliente() {
		ClienteController clienteController = new ClienteController();
		Cliente cliente = new Cliente();
		System.out.println("Por favor, informe o cpf do cliente que deseja excluir: ");
		String cpf = leTeclado.next();
		leTeclado.nextLine();
		cliente = clienteController.procurar(cpf);
		System.out.println("Cliente informado: " + cliente.getNome());
		System.out.println("Confirma? [ 1 ] Sim [ 2 ] Não ");
		int opcao = leTeclado.nextInt();
		if (opcao == 1) {
			clienteController.deletar(cliente);
			System.out.println("Cliente excluído");
		}else {
			System.out.println("Operação cancelada pelo usuário");
		}
		
		
	}
	
	
}


