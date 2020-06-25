package br.unit.lojaoDasPecas.controllers;

import java.util.List;

import br.unit.lojaoDasPecas.entidades.ConsultaVendas;
import br.unit.lojaoDasPecas.repository.ConsultaVendasDAO;

public class ConsultaVendasController {
ConsultaVendasDAO cvdao = new ConsultaVendasDAO(); 
	
	public List<ConsultaVendas> getConsulta(){
		return cvdao.getConsulta();
	}

}
