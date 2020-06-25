package br.unit.lojaoDasPecas;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.unit.lojaoDasPecas.exception.ClienteException;
import br.unit.lojaoDasPecas.exception.VendedorException;

import br.unit.lojaoDasPecas.view.ConsultaProdutoView;
import br.unit.lojaoDasPecas.view.ConsultaVendasView;
import br.unit.lojaoDasPecas.view.PedidoView;
import br.unit.lojaoDasPecas.view.ProdutoView;
import br.unit.lojaoDasPecas.view.VendedorView;

public class lojaoMain {



	private static VendedorView vendedorView = new VendedorView();
	private static ConsultaProdutoView cpview = new ConsultaProdutoView();
	private static ProdutoView produtoView = new ProdutoView();
	private static PedidoView pedidoView = new PedidoView();
	private static ConsultaVendasView cvview = new ConsultaVendasView();
	
	public static void main(String[] args) {
		Scanner leTeclado = new Scanner(System.in);
		
		System.out.println("---------------------------------");
		System.out.println("SEJA BEM VINDO AO LOJÃO DAS PEÇAS");
		System.out.println("---------------------------------");
		System.out.println();
		System.out.println("Escolha sua opção para prosseguir: ");
		int opcao = -1;
		int opcao2 = -1;
		do {
				try {
				carregarMenu();
				opcao = leTeclado.nextInt();
				
				if (opcao == 1) {
					menuVendedor();
					opcao2 = leTeclado.nextInt();
					if (opcao2 == 1) {
						vendedorView.cadastrarVendedor();
					}if (opcao2 == 2) {
						vendedorView.editarCadastro();
					}if (opcao2 == 3) {
						vendedorView.deletarVendedor();
					}if (opcao2 == 4) {
						vendedorView.listarVendedores();
					}if (opcao2 == 5) {
						leTeclado.nextLine();
					}
					
				}
				
				
				if (opcao == 2) {
					menuProduto();
					opcao2 = leTeclado.nextInt();
					if (opcao2 == 1) {
						produtoView.cadastrarProduto();
					}
					if (opcao2 == 2) {
						produtoView.editarProduto();
					}
					if (opcao2 == 3) {
						produtoView.deletarProdutos();
					}
					if (opcao2 == 4) {
						leTeclado.nextLine();
					}
				}
				
				
				if (opcao == 3) {
					menuPedido();
					opcao2 = leTeclado.nextInt();
					if (opcao2 == 1) {
						pedidoView.registrarPedido();
					}if (opcao2 == 2) {
						pedidoView.editarPedido();
					}if (opcao2 == 3) {
						pedidoView.deletarPedido();
					}if (opcao2 == 4) {
						pedidoView.listarPedidos();
					}if (opcao2 == 5) {
						leTeclado.nextLine();
					}
				}
				
				
				if (opcao == 4) {
					cpview.getConsulta();
				}
				if (opcao == 5) {
					cvview.getConsultaVendas();
				}
				
				
				} catch(ClienteException erro) {
					System.out.println("Erro. " + erro.getMessage());
				} catch(VendedorException erro1) {
					System.out.println("Erro. " + erro1.getMessage());
				} catch(InputMismatchException erro2) {
					System.out.println("Não é permitido inserir letras, informe apenas números");
					leTeclado.nextLine();
				} catch(RuntimeException e) {
					System.out.println("Não encontrado");
				} 
			
			
			
		} while (opcao != 999);
		System.out.println("Muito Obrigado por utilizar o nosso sistema. Até a próxima!");
		
		leTeclado.close();
		
	}

	private static void carregarMenu() {
		System.out.println();
		System.out.println("[ 1 ] - Vendedor");
		System.out.println("[ 2 ] - Produto");
		System.out.println("[ 3 ] - Pedido");
		System.out.println("[ 4 ] - Controle de Estoque");
		System.out.println("[ 5 ] - Consulta de Vendas");
		System.out.println("[ 999 ] - Sair");
		System.out.println("---------------------------------");
	}
	
	public static void menuPedido() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("             PEDIDO              ");
		System.out.println("---------------------------------");
		System.out.println("[ 1 ] Registrar Pedido\n"
				+ "[ 2 ] Alterar Pedido\n"
				+ "[ 3 ] Excluir Pedido \n"
				+ "[ 4 ] Listar Pedidos\n"
				+ "[ 5 ] Voltar" );
	}
	public static void menuVendedor() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("            VENDEDOR             ");
		System.out.println("---------------------------------");
		System.out.println("[ 1 ] Cadastrar Vendedor");
		System.out.println("[ 2 ] Editar Vendedor");
		System.out.println("[ 3 ] Excluir Vendedor");
		System.out.println("[ 4 ] Listar Vendedores");
		System.out.println("[ 5 ] Voltar");
	}
	public static void menuProduto() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("            PRODUTO              ");
		System.out.println("---------------------------------");
		System.out.println("[ 1 ] Cadastrar Produto");
		System.out.println("[ 2 ] Editar Produto");
		System.out.println("[ 3 ] Excluir Produto");
		System.out.println("[ 4 ] Voltar");
	}

}
