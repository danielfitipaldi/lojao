package br.unit.lojaoDasPecas.controllers;

import java.util.List;

import br.unit.lojaoDasPecas.entidades.ConsultaProduto;
import br.unit.lojaoDasPecas.repository.ConsultaProdutoDAO;

public class ConsultaProdutoController {
	ConsultaProdutoDAO cpdao = new ConsultaProdutoDAO(); 
	
	public List<ConsultaProduto> getConsulta(){
		return cpdao.getConsulta();
	}
}
