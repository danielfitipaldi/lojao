package br.unit.lojaoDasPecas.view;

import java.util.List;

import br.unit.lojaoDasPecas.controllers.ConsultaVendasController;
import br.unit.lojaoDasPecas.entidades.ConsultaVendas;

public class ConsultaVendasView {
ConsultaVendasController cpc = new ConsultaVendasController();
	
	public void getConsultaVendas(){
		List<ConsultaVendas> consulta = cpc.getConsulta();
		consulta.forEach(System.out::println);
	}

}
