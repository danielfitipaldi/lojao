package br.unit.lojaoDasPecas;

import br.unit.lojaoDasPecas.entidades.Cliente;
import br.unit.lojaoDasPecas.entidades.Pedido;
import br.unit.lojaoDasPecas.entidades.Produto;
import br.unit.lojaoDasPecas.entidades.Vendedor;
import br.unit.lojaoDasPecas.repository.ClienteDAO;
import br.unit.lojaoDasPecas.repository.PedidoDAO;
import br.unit.lojaoDasPecas.repository.VendedorDAO;

public class test {

	public static void main(String[] args) {
		Vendedor vendedor = new Vendedor();
		
		vendedor.setCpf("65432");
		vendedor.setBairro("Torre");
		vendedor.setNome("Felipe");
		vendedor.setSalario(2000.0);
		
		VendedorDAO vendao= new VendedorDAO();
		vendao.inserir(vendedor);
		
		Cliente cliente = new Cliente();
		
		cliente.setCidade("Recife");
		cliente.setCpf("12345");
		cliente.setNome("João");
		
		ClienteDAO clidao = new ClienteDAO();
		clidao.inserir(cliente);
		
		Produto produto = new Produto();
		
		produto.setEstoque(5);
		produto.setNome("rErovisorAAAaS");
		produto.setPreco(200.0);
		
		Pedido pedido = new Pedido();
		pedido.setQuantidade(1);
		pedido.setVendedor(vendedor);
		pedido.setCliente(cliente);
		pedido.setProduto(produto);
		
		PedidoDAO dao = new PedidoDAO(); 
		dao.inserir(pedido);
		

	}

}
