package br.unit.lojaoDasPecas.view;

import java.util.List;

import br.unit.lojaoDasPecas.controllers.ConsultaProdutoController;
import br.unit.lojaoDasPecas.entidades.ConsultaProduto;

public class ConsultaProdutoView {
	ConsultaProdutoController cpc = new ConsultaProdutoController();
	
	public void getConsulta(){
		List<ConsultaProduto> consulta = cpc.getConsulta();
		consulta.forEach(System.out::println);
	}
}
