package br.unit.lojaoDasPecas.view;

import java.util.List;

import br.unit.lojaoDasPecas.controllers.RelatorioVendasController;
import br.unit.lojaoDasPecas.entidades.RelatorioVendas;

public class RelatorioVendasView {
	RelatorioVendasController rvController = new RelatorioVendasController();
	
	public void getConsultaVendas(){
		List<RelatorioVendas> consulta = rvController.getConsulta();
		consulta.forEach(System.out::println);
	}
	

}
