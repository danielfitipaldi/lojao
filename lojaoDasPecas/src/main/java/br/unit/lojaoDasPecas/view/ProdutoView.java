package br.unit.lojaoDasPecas.view;

import java.util.List;
import java.util.Scanner;

import br.unit.lojaoDasPecas.controllers.ProdutoController;
import br.unit.lojaoDasPecas.entidades.Produto;
import br.unit.lojaoDasPecas.exception.ProdutoException;

public class ProdutoView {
	Scanner leTeclado = new Scanner(System.in);
	
	public Produto cadastrarProduto() {
	
		ProdutoController produtoController = new ProdutoController();
		
		System.out.println("CADASTRAR PRODUTO");
		System.out.println("Nome do produto: ");
		String nome = leTeclado.next();
		leTeclado.nextLine();
		
		System.out.println("Preço: ");
		Double preco = leTeclado.nextDouble();
		
		System.out.println("Quantidade em estoque: ");
		Integer estoque = leTeclado.nextInt();
		 
		Produto novoProduto = new Produto(null, nome, preco, estoque);
		produtoController.inserir(novoProduto);
		return novoProduto;
		
	}
	
	public void editarProduto() {
		ProdutoController produtoController = new ProdutoController();
		Produto produto = new Produto();
		
		System.out.println("ALTERAR PRODUTO");
		System.out.println("Qual produto você deseja alterar? ");
		String nome = leTeclado.next();
		leTeclado.nextLine();
		
		produto = produtoController.procurar(nome);
		if (produto == null) {
			throw new ProdutoException("Produto não localizado");
		}
		System.out.println("Nome do produto: " + produto.getNome());
		System.out.println("O que deseja alterar?\n "
				+ "[ 1 ] Nome do Produto \n"
				+ "[ 2 ] Preço do produto\n"
				+ "[ 3 ] Quantidade em estoque");
		int opcao = leTeclado.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Digite o novo nome: ");
			String novoNome = leTeclado.next();
			leTeclado.nextLine();
			produto.setNome(novoNome);
			produtoController.editar(produto);
			System.out.println("Atualização concluída");
			break;
		case 2:
			System.out.print("Digite o novo preço: ");
			Double preco = leTeclado.nextDouble();
			leTeclado.nextLine();
			produto.setPreco(preco);
			produtoController.editar(produto);
			System.out.println("Atualização concluída");
			break;
		case 3:
			System.out.println("Quantidade em estoque: ");
			Integer estoque = leTeclado.nextInt();
			produto.setEstoque(estoque);
			produtoController.editar(produto);
			System.out.println("Atualização concluída");
			break;
		}

	}
	
	public static void listarProdutos() {
		ProdutoController produtoController = new ProdutoController();
		List<Produto> produtos = produtoController.listaProdutos();
		produtos.forEach(System.out::println);
	}
	
	public void deletarProdutos() {
		ProdutoController produtoController = new ProdutoController();
		Produto produto = new Produto();
		System.out.println("Por favor, informe o nome do produto que deseja excluir: ");
		String nome = leTeclado.next();
		leTeclado.nextLine();
		produto = produtoController.procurar(nome);
		System.out.println("Produto informado: " + produto.getNome());
		System.out.println("Confirma? [ 1 ] Sim [ 2 ] Não ");
		int opcao = leTeclado.nextInt();
		if (opcao == 1) {
			produtoController.deletar(produto);
			System.out.println("Produto excluído");
		}else {
			System.out.println("Operação cancelada pelo usuário");
		}
		
	}
}
