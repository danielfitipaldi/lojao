package br.unit.lojaoDasPecas.view;

import java.util.List;

import br.unit.lojaoDasPecas.controllers.MaisVendidosController;
import br.unit.lojaoDasPecas.entidades.MaisVendidos;

public class MaisVendidosView {
	MaisVendidosController mvController = new MaisVendidosController();
	
	public void getConsultaVendas(){
		List<MaisVendidos> consulta = mvController.getConsulta();
		consulta.forEach(System.out::println);
	}
}