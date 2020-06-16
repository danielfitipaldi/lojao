package br.unit.lojaoDasPecas.view;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.unit.lojaoDasPecas.controllers.VendedorController;
import br.unit.lojaoDasPecas.entidades.Vendedor;
import br.unit.lojaoDasPecas.exception.VendedorException;


public class VendedorView {
	Scanner leTeclado = new Scanner(System.in);

	public Vendedor cadastrarVendedor() {

		System.out.println("Por favor, digite o CPF do Vendedor: ");
		String cpf = leTeclado.next();
		VendedorController vendedorController = new VendedorController();
		Vendedor vendedor = vendedorController.procurar(cpf);
		
		if (vendedor == null) {
			System.out.println("Nome: ");
			String nome = leTeclado.next();
			leTeclado.nextLine();

			System.out.println("Número do RG (Identidade): ");
			String rg = leTeclado.next();
			leTeclado.nextLine();

			System.out.println("Endereço: ");
			String endereco = leTeclado.next();
			leTeclado.nextLine();

			Random random = new Random();
			int COD_VENDEDOR = random.nextInt(101);

			Vendedor novoVendedor = new Vendedor(COD_VENDEDOR, nome, cpf, rg, endereco);
			vendedorController.inserir(novoVendedor);
			return novoVendedor;
		} else {
			System.out.println("Vendedor já cadastrado: " + vendedor.getNome());
			throw new VendedorException("Vendedor já cadastrado");
		}
	}

	public void editarCadastro() {

		VendedorController vendedorController = new VendedorController();
		Vendedor vendedor = new Vendedor();

		System.out.println("EDITAR VENDEDOR");
		System.out.println("Digite o CPF da pessoa a ter sua conta alterada: ");
		String cpf = leTeclado.next();
		leTeclado.nextLine();
		vendedor = vendedorController.procurar(cpf);
		if (vendedor == null) {
			throw new VendedorException("Não localizamos o vendedor");
		}
		
		System.out.println("Nome do vendedor: " + vendedor.getNome());
		System.out.println("O que deseja alterar? [ 1 ] Nome do Cliente \n"
				+ "[ 2 ] RG \n"
				+ "[ 3 ] Endereço");
		int opcao = leTeclado.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Digite o novo nome");
			String nome = leTeclado.next();
			leTeclado.nextLine();
			vendedor.setNome(nome);
			vendedorController.atualizar(vendedor);
			System.out.println("Atualização concluída");
			break;
		case 2:
			System.out.println("Digite o novo RG");
			String rg = leTeclado.next();
			leTeclado.nextLine();
			vendedor.setRg(rg);
			vendedorController.atualizar(vendedor);
			System.out.println("Atualização concluída");
			break;
		case 3:
			System.out.println("Digite o novo Endereço");
			String endereco = leTeclado.next();
			leTeclado.nextLine();
			vendedor.setEndereco(endereco);
			vendedorController.atualizar(vendedor);
			System.out.println("Atualização concluída");
			break;
		}

	}
	
	public static void listarVendedores() {
		VendedorController vendedorController = new VendedorController();
		List<Vendedor> vendedores = vendedorController.listaVendedores();
		vendedores.forEach(System.out::println);
		
	}
	
	public void deletarVendedor() {
		VendedorController vendedorController = new VendedorController();
		Vendedor vendedor = new Vendedor();
		System.out.println("Excluir? Por favor, informe o CPF do vendedor: ");
		String cpf = leTeclado.next();
		leTeclado.nextLine();
		vendedor = vendedorController.procurar(cpf);
		System.out.println("Vendedor informado: " + vendedor.getNome());
		System.out.println("Confirma? [ 1 ] Sim [ 2 ] Não ");
		int opcao = leTeclado.nextInt();
		if (opcao == 1) {
			vendedorController.deletar(vendedor);
			System.out.println("Vendedor excluído");
		}else {
			System.out.println("Operação cancelada pelo usuário");
		}
		
		
	}
	
	
	

}
