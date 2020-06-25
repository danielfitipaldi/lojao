package br.unit.lojaoDasPecas.view;

import java.util.List;
import java.util.Scanner;

import br.unit.lojaoDasPecas.controllers.ClienteController;
import br.unit.lojaoDasPecas.controllers.PedidoController;
import br.unit.lojaoDasPecas.controllers.ProdutoController;
import br.unit.lojaoDasPecas.controllers.VendedorController;
import br.unit.lojaoDasPecas.entidades.Cliente;
import br.unit.lojaoDasPecas.entidades.Pedido;
import br.unit.lojaoDasPecas.entidades.Produto;
import br.unit.lojaoDasPecas.entidades.Vendedor;
import br.unit.lojaoDasPecas.exception.ClienteException;
import br.unit.lojaoDasPecas.exception.PedidoException;




public class PedidoView extends ClienteView{
	Scanner leTeclado = new Scanner(System.in);
	
	public Pedido registrarPedido() {
		PedidoController pedidoController = new PedidoController();
		Pedido novoPedido = new Pedido();
		
		novoPedido.setIdPedido(null);
		
		System.out.println("[ 1 ] Novo Cliente\n[ 2 ] Cliente já cadastrado");
		int opcao = leTeclado.nextInt();
		switch (opcao) {
		case 1:
			novoPedido.setCliente(cadastrarCliente());
			break;
		
		case 2 :
			ClienteController clienteController = new ClienteController();
			Cliente cliente = new Cliente();
			System.out.println("Digite o CPF do cliente: ");
			String cpf = leTeclado.next();
			cliente = clienteController.procurar(cpf);
			if (cpf == null) {
				throw new ClienteException("Cliente não encontrado. Favor efetuar o cadastro");
			}else {
				novoPedido.setCliente(cliente);
				System.out.println("Cliente: " + cliente.getNome());
			}
			break;
		}	
		
	
		
		Vendedor vendedor = new Vendedor();
		VendedorController vendedorController = new VendedorController();
		
		System.out.println("Vendedor responsável: ");
		String nomeVendedor = leTeclado.next();
		vendedor = vendedorController.procurarNome(nomeVendedor);
		novoPedido.setVendedor(vendedor);
		
		Produto produto = new Produto();
		ProdutoController produtoController = new ProdutoController();
		System.out.println("Nome do produto: ");
		String nomeProduto = leTeclado.next();
		produto = produtoController.procurar(nomeProduto);
		novoPedido.setProduto(produto);
		
		System.out.println("Quantidade: ");
		Integer quantidade = leTeclado.nextInt();
		novoPedido.setQuantidade(quantidade);
		
		pedidoController.inserir(novoPedido);
		return novoPedido;
		
	}
	public static void listarPedidos() {
		PedidoController pedidoController = new PedidoController();
		List<Pedido> pedidos = pedidoController.listaPedidos();
		pedidos.forEach(System.out::println);
		
	}
	
	public void editarPedido() {
		PedidoController pedidoController = new PedidoController();
		Pedido pedido = new Pedido();
		
		System.out.println("---------------------------------");
		System.out.println("          EDITAR PEDIDO          ");
		System.out.println("---------------------------------");
		System.out.println("Digite o ID do pedido que a ser alterado: ");
		Integer idPedido = leTeclado.nextInt();
		leTeclado.nextLine();
		pedido = pedidoController.procurar(idPedido);
		if (pedido == null) {
			throw new PedidoException("Pedido não localizado");
		}
		System.out.println(pedido.getIdPedido() + " Pedido de " + pedido.getCliente().getNome());
		System.out.println("O que deseja alterar?\n"
				+ "[ 1 ] Alterar produto "
				+ "[ 2 ] Alterar quantidade "
				+ "[ 3 ] Editar cliente"
				+ "[ 4 ] Cancelar");
		int opcao = leTeclado.nextInt();
		switch (opcao) {
		case 1:
			Produto produto = new Produto();
			ProdutoController produtoController = new ProdutoController();
			System.out.println("Nome do produto: ");
			String nomeProduto = leTeclado.next();
			produto = produtoController.procurar(nomeProduto);
			System.out.println("Deseja alterar " + pedido.getProduto() + "para " + nomeProduto + " ?");
			pedido.setProduto(produto);
			pedidoController.atualizar(pedido);
			System.out.println("Atualização concluída");
			break;
		
		case 2:
			System.out.println("Quantidade: ");
			Integer quantidade = leTeclado.nextInt();
			leTeclado.nextLine();
			pedido.setQuantidade(quantidade);
			pedidoController.atualizar(pedido);
			System.out.println("Atualização concluída");
			break;
			
		case 3:
			Cliente cliente = new Cliente();
			ClienteController clienteController = new ClienteController();
			System.out.println("EDITAR CLIENTE");
			System.out.println("Para confirmar que se trata do mesmo cliente, "
					+ "por favor digite CPF da pessoa a ter sua conta alterada: ");
			String cpf = leTeclado.next();
			leTeclado.nextLine();
			cliente = clienteController.procurar(cpf);
			if (cliente == null) {
				throw new ClienteException("Cliente não localizado");
			}
			System.out.println("Nome do cliente: " + cliente.getNome());
			System.out.println("O que deseja alterar?\n[ 1 ] Nome do Cliente \n"
					+ "[ 2 ] Cidade \n"
					+ "[ 3 ] Cancelar");
			int opcao2 = leTeclado.nextInt();
			switch (opcao2) {
			case 1:
				System.out.println("Digite o novo nome");
				String nome = leTeclado.next();
				leTeclado.nextLine();
				cliente.setNome(nome);
				pedido.setCliente(cliente);
				pedidoController.atualizar(pedido);;
				System.out.println("Atualização concluída");
				break;
			case 2:
				System.out.print("Digite a nova Cidade: ");
				String cidade = leTeclado.next();
				leTeclado.nextLine();
				cliente.setCidade(cidade);
				pedido.setCliente(cliente);
				pedidoController.atualizar(pedido);
				System.out.println("Atualização concluída");
				break;
			case 3:
				System.out.println("Operação Cancelada pelo usuário");
			}
		case 4:
			System.out.println("Operação Cancelada pelo usuário");
			
		}
	}

	
	public void deletarPedido() {
		Pedido pedido = new Pedido();
		PedidoController pedidoController = new PedidoController();
		System.out.println("Por favor, informe o código do Pedido: ");
		Integer idPedido = leTeclado.nextInt();
		leTeclado.nextLine();
		pedido = pedidoController.procurar(idPedido);
		System.out.println("ID Pedido: " + pedido.getIdPedido() + " do cliente " + pedido.getCliente().getNome());
		System.out.println("Confirma? [ 1 ] Sim [ 2 ] Não ");
		int opcao = leTeclado.nextInt();
		if (opcao == 1) {
			pedidoController.deletar(pedido);
			System.out.println("Pedido excluído");
		} else {
			System.out.println("Operação cancelada pelo usuário");
		}

	}
	
	
		
	
}


