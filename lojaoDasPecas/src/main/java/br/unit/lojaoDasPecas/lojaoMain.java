package br.unit.lojaoDasPecas;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.unit.lojaoDasPecas.exception.ClienteException;
import br.unit.lojaoDasPecas.exception.VendedorException;
import br.unit.lojaoDasPecas.view.ClienteView;
import br.unit.lojaoDasPecas.view.VendedorView;

public class lojaoMain {


	private static ClienteView clienteView = new ClienteView();
	private static VendedorView vendedorView = new VendedorView();

	
	public static void main(String[] args) {
		Scanner leTeclado = new Scanner(System.in);
		
		System.out.println("Bem vindo ao Lojão das Peças");
		
		int opcao = -1;
		do {
				try {
				carregarMenu();
				opcao = leTeclado.nextInt();
				
				if (opcao == 1) {
					clienteView.cadastrarCliente();
				}if (opcao == 2) {
					clienteView.editarCadastro();
				}if (opcao == 3) {
					clienteView.deletarCliente(); 
				}if (opcao == 4) {
					vendedorView.cadastrarVendedor();
				}if (opcao == 5) {
					vendedorView.editarCadastro();
				}if (opcao == 6) {
					vendedorView.deletarVendedor();
				}if (opcao == 7) {
					clienteView.listarClientes();
				}if (opcao == 8) {
					vendedorView.listarVendedores();
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
		System.out.println("Muito Obrigado");
		
		leTeclado.close();
		
	}

	private static void carregarMenu() {
		System.out.println();
		System.out.println("[1] - Cadastrar Cliente");
		System.out.println("[2] - Editar Cliente");
		System.out.println("[3] - Excluir Cliente");
		System.out.println("[4] - Cadastrar Vendedor");
		System.out.println("[5] - Editar Vendedor");
		System.out.println("[6] - Excluir Vendedor");
		System.out.println("[7] - Listar todos os clientes");
		System.out.println("[8] - Listar todos os vendedores");
		System.out.println("[999] - Sair");
	}

}
