package br.unit.lojaoDasPecas.view;

import java.util.List;
import java.util.Random;
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
			System.out.println();

			System.out.println("Número do RG (Identidade): ");
			String rg = leTeclado.next();
			System.out.println();
			leTeclado.nextLine();
			
			System.out.println("Endereço. Rua: ");
			String endereco = leTeclado.nextLine();
			System.out.println();

			Random random = new Random();
			int COD_CLIENTE = random.nextInt(101);

			Cliente novoCliente = new Cliente(COD_CLIENTE, nome, cpf, rg, endereco);
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
				+ "[ 2 ] RG \n"
				+ "[ 3 ] Endereço");
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
			System.out.println("Digite o novo RG");
			String rg = leTeclado.next();
			leTeclado.nextLine();
			cliente.setRg(rg);
			clienteController.atualizar(cliente);
			System.out.println("Atualização concluída");
			break;
		case 3:
			System.out.print("Digite o novo Endereço");
			String endereco = leTeclado.next();
			leTeclado.nextLine();
			cliente.setEndereco(endereco);
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


