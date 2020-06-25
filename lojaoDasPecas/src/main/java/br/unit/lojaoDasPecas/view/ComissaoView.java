package br.unit.lojaoDasPecas.view;

import java.util.List;

import br.unit.lojaoDasPecas.controllers.ComissaoController;
import br.unit.lojaoDasPecas.entidades.Comissao;

public class ComissaoView {
	ComissaoController comissaoController = new ComissaoController();
	
	public void getConsulta(){
		List<Comissao> comissao = comissaoController.getConsulta();
		comissao.forEach(System.out::println);
	}

}
